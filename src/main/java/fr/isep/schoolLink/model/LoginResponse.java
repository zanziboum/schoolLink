package fr.isep.schoolLink.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private final String accessToken;
}
