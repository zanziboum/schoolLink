package fr.isep.schoolLink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserEntity {
    @Id
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String role;
    private String extraInfo;

}
