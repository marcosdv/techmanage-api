package br.com.marcosdiasvendramini.techmanage_api.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.marcosdiasvendramini.techmanage_api.dto.UserRequestDTO;
import br.com.marcosdiasvendramini.techmanage_api.enums.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class UserIntegrationPutTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8")
            .withDatabaseName("techmanage")
            .withUsername("dev")
            .withPassword("dev123");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldUpdateUser() throws Exception {
        // Primeiro cria um usuário
        UserRequestDTO dto = new UserRequestDTO(
                "Maria Souza",
                "maria@teste.com",
                "+55 11 98765-4321",
                LocalDate.of(1995, 5, 20),
                UserType.EDITOR
        );

        String response = mockMvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(response).get("id").asLong();

        // Atualiza o usuário criado
        UserRequestDTO updateDto = new UserRequestDTO(
                "Maria Souza Atualizada",
                "maria@teste.com",
                "+55 11 98765-4321",
                LocalDate.of(1995, 5, 20),
                UserType.ADMIN
        );

        mockMvc.perform(put("/api/users/" + userId)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Maria Souza Atualizada"))
                .andExpect(jsonPath("$.userType").value("ADMIN"));
    }
}
