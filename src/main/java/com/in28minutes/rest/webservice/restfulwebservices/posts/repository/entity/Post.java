package com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservice.restfulwebservices.user.repository.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 10, max = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

}
