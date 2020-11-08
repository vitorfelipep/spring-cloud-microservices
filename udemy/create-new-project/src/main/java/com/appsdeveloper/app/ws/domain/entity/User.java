package com.appsdeveloper.app.ws.domain.entity;

import com.appsdeveloper.app.ws.domain.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String cpf;
    private String name;
    private String email;



    public User(UserDTO userDTO) {
        this.id = userDTO.getKey();
        this.cpf = userDTO.getCpf();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }
}
