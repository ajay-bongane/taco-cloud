package com.example.tacocloud.tacos;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message = "Name must be atleast 5 characters long")
    private String name;

    @ManyToMany
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
