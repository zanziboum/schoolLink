package fr.isep.schoolLink.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserInterestEntity {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "subject_of_interest_id")
    private SubjectOfInterestEntity subjectOfInterest;
}
