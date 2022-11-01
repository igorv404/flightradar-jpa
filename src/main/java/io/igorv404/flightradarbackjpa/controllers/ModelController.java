package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Model;
import io.igorv404.flightradarbackjpa.services.ModelService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

  private final ModelService modelService;

  public ModelController(ModelService modelService) {
    this.modelService = modelService;
  }

  @GetMapping
  public List<Model> getAll() {
    return this.modelService.getAll();
  }

  @GetMapping("/{id}")
  public Model getById(@PathVariable String id) {
    return this.modelService.getById(id);
  }

  @PostMapping
  public Model create(@RequestBody Model entity) {
    return this.modelService.create(entity);
  }

  @PutMapping("/{id}")
  public Model update(@PathVariable String id, @RequestBody Model entity) {
    return this.modelService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.modelService.delete(id);
  }
}
