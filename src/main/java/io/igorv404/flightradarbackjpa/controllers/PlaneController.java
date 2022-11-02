package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.PlaneDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.PlaneDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Plane;
import io.igorv404.flightradarbackjpa.services.PlaneService;
import org.springframework.hateoas.CollectionModel;
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
  private final PlaneDTOAssembler planeDTOAssembler;

  public PlaneController(PlaneService planeService, PlaneDTOAssembler planeDTOAssembler) {
    this.planeService = planeService;
    this.planeDTOAssembler = planeDTOAssembler;
  }

  @GetMapping
  public CollectionModel<PlaneDTO> getAll() {
    List<Plane> planes = this.planeService.getAll();
    return this.planeDTOAssembler.toCollectionModel(planes);
  }

  @GetMapping("/{id}")
  public PlaneDTO getById(@PathVariable Integer id) {
    Plane plane = this.planeService.getById(id);
    return this.planeDTOAssembler.toModel(plane);
  }

  @PostMapping("/{companyName}/{modelName}")
  public PlaneDTO create(@PathVariable String companyName, @PathVariable String modelName, @RequestBody Plane entity) {
    Plane plane = this.planeService.create(entity, companyName, modelName);
    return this.planeDTOAssembler.toModel(plane);
  }

  @PutMapping("/{id}")
  public PlaneDTO update(@PathVariable Integer id, @RequestBody Plane entity) {
    Plane plane = this.planeService.update(id, entity);
    return this.planeDTOAssembler.toModel(plane);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.planeService.delete(id);
  }
}
