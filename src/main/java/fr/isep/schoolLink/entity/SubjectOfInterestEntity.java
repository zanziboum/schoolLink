package fr.isep.schoolLink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class SubjectOfInterestEntity {
    @Id
    @GeneratedValue
    Long id;
    String name;


}