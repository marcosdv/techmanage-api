package br.com.marcosdiasvendramini.techmanage_api.service;

import br.com.marcosdiasvendramini.techmanage_api.dto.UserRequestDTO;
import br.com.marcosdiasvendramini.techmanage_api.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserRequestDTO dto);

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(Long id);

    UserResponseDTO update(Long id, UserRequestDTO dto);

    void delete(Long id);

}