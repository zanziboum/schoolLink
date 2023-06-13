package fr.isep.schoolLink.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NotificationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String message;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
}
