package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Plane;
import io.igorv404.flightradarbackjpa.services.PlaneService;
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
@RequestMapping("/planes")
public class PlaneController {
  private final PlaneService planeService;

  public PlaneController(PlaneService planeService) {
    this.planeService = planeService;
  }

  @GetMapping
  public List<Plane> getAll() {
    return this.planeService.getAll();
  }

  @GetMapping("/{id}")
  public Plane getById(@PathVariable Integer id) {
    return this.planeService.getById(id);
  }

  @PostMapping("/{companyName}/{modelName}")
  public Plane create(@PathVariable String companyName, @PathVariable String modelName, @RequestBody Plane entity) {
    return this.planeService.create(entity, companyName, modelName);
  }

  @PutMapping("/{id}")
  public Plane update(@PathVariable Integer id, @RequestBody Plane entity) {
    return this.planeService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.planeService.delete(id);
  }
}
