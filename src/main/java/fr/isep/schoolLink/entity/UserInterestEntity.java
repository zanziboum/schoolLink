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
    @JoinColumn(name = "formation_id")
    private SchoolFormationEntity formation;
}
