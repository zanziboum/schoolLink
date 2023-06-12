package fr.isep.schoolLink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SchoolFormationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @ManyToOne
    @JoinColumn(name = "subject_of_interest_id")
    private SubjectOfInterestEntity subjectOfInterest;

}
