    package fr.isep.schoolLink.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToMany;
    import lombok.Data;

    import java.util.List;

    @Data
    @Entity
    public class SchoolEntity {
        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String address;

        @OneToMany(mappedBy = "school")
        private List<SchoolFormationEntity> formations;

        @OneToMany(mappedBy = "school")
        private List<FollowEntity> followedSchools;
    }
