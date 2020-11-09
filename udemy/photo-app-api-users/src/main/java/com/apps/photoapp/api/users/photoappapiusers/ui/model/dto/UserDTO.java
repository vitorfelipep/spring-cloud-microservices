package com.apps.photoapp.api.users.photoappapiusers.ui.model.dto;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.entity.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "First name cannot be empty or blank")
    @Size(min = 3, message = "First name must not be less than two characters")
    private String firstName;

    @NotBlank(message = "First name cannot be empty or blank")
    @Size(min = 3, message = "Last name must not be less than two characters")
    private String lastName;

    @NotBlank(message = "Password cannot be empty or blank")
    @Size(min = 8, max = 16,message = "Password must not be less than 8 characters and greater than 16 characters!")
    private String password;

    @Email
    @NotNull(message = "Email cannot be empty or blank")
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
