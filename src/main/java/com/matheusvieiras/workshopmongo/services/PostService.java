package com.matheusvieiras.workshopmongo.services;

import com.matheusvieiras.workshopmongo.domain.Post;
import com.matheusvieiras.workshopmongo.repository.PostRepository;
import com.matheusvieiras.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
