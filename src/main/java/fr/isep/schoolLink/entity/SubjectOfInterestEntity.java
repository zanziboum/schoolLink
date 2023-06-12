package fr.isep.schoolLink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class SubjectOfInterestEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectOfInterest")
    private List<SchoolFormationEntity> schoolFormations;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectOfInterest")
    private List<UserInterestEntity> userInterests;
}
