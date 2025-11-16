package br.com.marcosdiasvendramini.techmanage_api.dto;

import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;

import java.time.LocalDate;

public class UserResponseDTO {

    public UserResponseDTO() { }

    public UserResponseDTO(Long id, String fullName, String email, String phone, LocalDate birthDate, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private UserType userType;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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
