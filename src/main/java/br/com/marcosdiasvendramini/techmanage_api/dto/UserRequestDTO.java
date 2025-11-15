package br.com.marcosdiasvendramini.techmanage_api.dto;

import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Pattern(
        regexp = "^\\+\\d{1,3}\\s\\d{2}\\s\\d{4,5}-\\d{4}$",
        message = "Telefone deve estar no formato internacional, ex: +55 11 99999-9999"
    )
    private String phone;

    @Past(message = "Data de nascimento inválida")
    private LocalDate birthDate;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private UserType userType;

}