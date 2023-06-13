package fr.isep.schoolLink.service;

import fr.isep.schoolLink.entity.FollowEntity;
import fr.isep.schoolLink.entity.NotificationEntity;
import fr.isep.schoolLink.entity.SchoolEntity;
import fr.isep.schoolLink.entity.UserEntity;
import fr.isep.schoolLink.repository.FollowRepository;
import fr.isep.schoolLink.repository.NotificationRepository;
import fr.isep.schoolLink.repository.SchoolRepository;
import fr.isep.schoolLink.repository.UserRepository;
import fr.isep.schoolLink.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {

    NotificationRepository notificationRepository;
    UserRepository userRepository;
    FollowRepository followRepository;

    SchoolRepository schoolRepository;

    public List<NotificationEntity> getNotificationsBySchool(SchoolEntity school) {
        return notificationRepository.findBySchool(school);
    }

    public List<NotificationEntity> getNotificationFromUserPrincipal(UserPrincipal userPrincipal){

        List<NotificationEntity> notifications = new ArrayList<>();
        Optional<UserEntity> userOptional = userRepository.findById(userPrincipal.getUserId());

        if (userOptional.isEmpty() ) return notifications;

        List<FollowEntity> follows = followRepository.findByUser(userOptional.get());
        List<SchoolEntity> followedSchools = follows.stream().map(FollowEntity::getSchool).toList();
        followedSchools.forEach(school -> {
            notifications.addAll(
                    notificationRepository.findBySchool(school)
            );
        });
        return notifications;
    }

    public void createNotification(String schoolName, String title, String message){
        System.out.println(schoolName);
        Optional<SchoolEntity> schoolOptional = schoolRepository.findByName(schoolName);
        if ( schoolOptional.isEmpty()) return;
        NotificationEntity notification = new NotificationEntity();
        notification.setMessage(message);
        notification.setTitle(title);
        notification.setSchool(schoolOptional.get());
        notificationRepository.save(notification);


    }
}
