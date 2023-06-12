package fr.isep.schoolLink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class SchoolEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String email;
    @JsonIgnore
    private String password;
    private String role;

    private String info;
    private String imageUrl;
    private String bannerUrl;


    @OneToMany(mappedBy = "school")
    private List<SchoolFormationEntity> formations;


}
