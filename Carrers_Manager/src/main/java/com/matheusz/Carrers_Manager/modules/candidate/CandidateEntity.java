package com.matheusz.Carrers_Manager.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The user name field must not have blank spaces")
    private String userName;

    @Email(message = "The email is not valid")
    private String email;

    @Length(min = 10, max = 100, message="The password must have between 10 and 100 characters")
    private String password;
    private String description;
    private String curriculum;
}
