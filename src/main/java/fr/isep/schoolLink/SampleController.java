package fr.isep.schoolLink;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {
    @GetMapping("/user/information")
    public Map<String, Object> currentUser (OAuth2AuthenticationToken oAuth2AuthenticationToken){
        Map map = oAuth2AuthenticationToken.getPrincipal().getAttributes();
        return map;
    }

    public String getFirstName(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("given_name")) {
               result =  map.values().toString();
            }
        }
        return result;
    }
    public String getLastName(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("family_name")) {
                result =  map.values().toString();
            }
        }
        return result;
    }
    public String getEmail(Map map) {
        String result = null;
        for (int i = 0;i< map.size(); i++) {
            if (map.containsKey("email")) {
                result =  map.values().toString();
            }
        }
        return result;
    }
}
