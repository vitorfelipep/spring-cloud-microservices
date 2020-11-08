package com.appsdeveloper.app.ws.domain.dto;

import com.appsdeveloper.app.ws.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String key;

    @CPF(message = "CPF must be a valid CPF and cannot be missing or empty")
    private String cpf;

    @NotBlank(message = "Name cannot be missing or empty")
    @Size(min = 2, message = "Name must not be less tha 2 characters")
    private String name;

    @Email(message = "Email must be a valid and cannot be missing or empty")
    private String email;

    public UserDTO(User user) {
        this.key = user.getId();
        this.cpf = user.getCpf();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
