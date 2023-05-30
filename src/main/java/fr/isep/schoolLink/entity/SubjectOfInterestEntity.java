package fr.isep.schoolLink.entity;

import fr.isep.schoolLink.data.ReadJsonFile;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class SubjectOfInterestEntity{
    @Id
    @GeneratedValue
    Long id;
    String name;

}
