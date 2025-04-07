package com.in28minutes.rest.webservice.restfulwebservices.posts.service;

import com.in28minutes.rest.webservice.restfulwebservices.exceptions.PostNotFoundException;
import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.PostRepository;
import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity.Post;
import com.in28minutes.rest.webservice.restfulwebservices.user.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostEntityService {

    private final PostRepository postRepository;
    private final UserEntityService userEntityService;

    public Post createPostForUser(Integer userId, Post post) {
        post.setUser(userEntityService.findById(userId));
        return this.postRepository.save(post);
    }

    public Post getPostById(Integer postId) {

        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent())
            return optionalPost.get();
        else
            throw new PostNotFoundException(String.format("Post with id %s does not exist!", postId));

    }
}
