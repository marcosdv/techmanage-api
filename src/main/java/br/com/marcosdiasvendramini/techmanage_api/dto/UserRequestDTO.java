package br.com.marcosdiasvendramini.techmanage_api.dto;

import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserRequestDTO {

    public UserRequestDTO() { }

    public UserRequestDTO (String fullName, String email, String phone, LocalDate birthDate, UserType userType) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Pattern(regexp = "^\\+\\d{1,3}\\s\\d{2}\\s\\d{4,5}-\\d{4}$", message = "Telefone deve estar no formato internacional, ex: +55 11 99999-9999")
    private String phone;

    @Past(message = "Data de nascimento deve ser uma data passada")
    private LocalDate birthDate;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private UserType userType;

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}