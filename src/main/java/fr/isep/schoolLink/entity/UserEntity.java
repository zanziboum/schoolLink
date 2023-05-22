package fr.isep.schoolLink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String role;
    private String extraInfo;

    @OneToMany(mappedBy = "user")
    private Set<UserInterestEntity> interests;

}
