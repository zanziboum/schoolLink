package fr.isep.schoolLink.model;

import lombok.Data;
@Data
public class SignUpRequest {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String address;
}
