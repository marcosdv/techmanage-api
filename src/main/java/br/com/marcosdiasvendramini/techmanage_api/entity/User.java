package br.com.marcosdiasvendramini.techmanage_api.entity;

import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @Email(message = "E-mail informado inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Pattern(regexp = "^\\+\\d{1,3}\\s\\d{2}\\s\\d{4,5}-\\d{4}$", message = "Telefone deve estar no formato internacional")
    private String phone;

    @Past(message = "Data de nascimento deve ser uma data passada")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}
