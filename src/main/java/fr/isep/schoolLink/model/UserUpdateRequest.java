package fr.isep.schoolLink.model;

import lombok.Data;

import java.util.List;

@Data
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String address;
    private List<String> interests;
}
