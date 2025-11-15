package br.com.marcosdiasvendramini.techmanage_api.dto;

import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private UserType userType;

}
