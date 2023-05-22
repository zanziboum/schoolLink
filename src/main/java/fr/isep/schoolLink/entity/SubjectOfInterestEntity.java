package fr.isep.schoolLink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class SubjectOfInterestEntity {
    @Id
    @GeneratedValue
    Long id;
    String name;

}
