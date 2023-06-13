package fr.isep.schoolLink.model;

import lombok.Data;

@Data
public class NotificationRequest {
    private String schoolName;
    private String title;
    private String message;
}
