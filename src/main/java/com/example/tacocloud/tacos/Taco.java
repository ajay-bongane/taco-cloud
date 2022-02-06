package com.example.tacocloud.tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min=5, message = "Name must be atleast 5 characters long")
    String name;

    @NotNull
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    List<String> ingredients;
}
