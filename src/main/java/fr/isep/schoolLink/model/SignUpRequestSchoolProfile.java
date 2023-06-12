package fr.isep.schoolLink.model;

import lombok.Data;

@Data
public class SignUpRequestSchoolProfile {
    private String name;
    private String email;
    private String password;
    private String address;
}
