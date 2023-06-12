package fr.isep.schoolLink.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.isep.schoolLink.model.Publication;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PublicationController {

    private List<Publication> publications = new ArrayList<>();

    @PostMapping("/publications")
    public void addPublication(@RequestBody Publication publication) {
        // Ajoutez la nouvelle publication à la liste des publications
        publications.add(publication);
    }

    @GetMapping("/publications")
    public List<Publication> getAllPublications() {
        // Récupérez toutes les publications
        return publications;
    }
}

