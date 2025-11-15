package br.com.marcosdiasvendramini.techmanage_api.service;

import br.com.marcosdiasvendramini.techmanage_api.dto.UserRequestDTO;
import br.com.marcosdiasvendramini.techmanage_api.dto.UserResponseDTO;
import br.com.marcosdiasvendramini.techmanage_api.entity.User;
import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import br.com.marcosdiasvendramini.techmanage_api.exception.ResourceNotFoundException;
import br.com.marcosdiasvendramini.techmanage_api.repository.UserRepository;
import br.com.marcosdiasvendramini.techmanage_api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    void shouldCreateUser() {
        UserRequestDTO dto = new UserRequestDTO(
            "João Silva",
            "joao@teste.com",
            "+55 11 91234-5678",
            LocalDate.of(1990, 1, 1),
            UserType.ADMIN
        );

        long userId = 1;

        User user = new User();
        user.setId(userId);
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setBirthDate(dto.getBirthDate());
        user.setUserType(dto.getUserType());

        when(mapper.map(dto, User.class)).thenReturn(user);
        when(repository.save(user)).thenReturn(user);
        when(mapper.map(user, UserResponseDTO.class)).thenReturn(
            new UserResponseDTO(user.getId(), user.getFullName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getUserType())
        );

        UserResponseDTO result = service.create(dto);

        assertNotNull(result);
        assertEquals("joao@teste.com", result.getEmail());
        verify(repository, times(1)).save(user);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }
}
