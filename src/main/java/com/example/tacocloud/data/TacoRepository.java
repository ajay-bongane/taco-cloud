package com.example.tacocloud.data;

import com.example.tacocloud.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, String> {
}
