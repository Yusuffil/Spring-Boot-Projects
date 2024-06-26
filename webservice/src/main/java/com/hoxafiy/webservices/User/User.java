package com.hoxafiy.webservices.User;

import com.hoxafiy.webservices.User.validation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "{hoaxify.constraint.username.notblank}")
    @Size(min=4, max = 255)
    private String username;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotNull
    @Size(min=8,max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hoaxify.constraint.password.pattern}")
    private String password;

    private boolean active = false;

    private String activationToken;

}
