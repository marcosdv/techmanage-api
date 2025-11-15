package br.com.marcosdiasvendramini.techmanage_api.service.impl;

import br.com.marcosdiasvendramini.techmanage_api.dto.UserRequestDTO;
import br.com.marcosdiasvendramini.techmanage_api.dto.UserResponseDTO;
import br.com.marcosdiasvendramini.techmanage_api.entity.User;
import br.com.marcosdiasvendramini.techmanage_api.exception.ResourceNotFoundException;
import br.com.marcosdiasvendramini.techmanage_api.repository.UserRepository;
import br.com.marcosdiasvendramini.techmanage_api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = mapper.map(dto, User.class);
        return mapper.map(repository.save(user), UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> mapper.map(user, UserResponseDTO.class))
                .toList();
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        mapper.map(dto, user);
        return mapper.map(repository.save(user), UserResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        repository.deleteById(id);
    }
}