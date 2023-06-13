package fr.isep.schoolLink.controller;

import fr.isep.schoolLink.entity.NotificationEntity;
import fr.isep.schoolLink.model.NotificationRequest;
import fr.isep.schoolLink.security.UserPrincipal;
import fr.isep.schoolLink.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/notification")
public class NotificationController {

    final NotificationService notificationService;

    @GetMapping("get")
    public List<NotificationEntity> getAllNotification(@AuthenticationPrincipal UserPrincipal principal){
        return notificationService.getNotificationFromUserPrincipal(principal);
    }

    @PostMapping("add")
    public void addNotification(@RequestBody NotificationRequest request){
        notificationService.createNotification(
                request.getSchoolName(),
                request.getTitle(),
                request.getMessage());
    }
}
