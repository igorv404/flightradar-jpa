package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Airport;
import io.igorv404.flightradarbackjpa.services.AirportService;
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
@RequestMapping("/airports")
public class AirportController {
  private final AirportService airportService;

  public AirportController(AirportService airportService) {
    this.airportService = airportService;
  }

  @GetMapping
  public List<Airport> getAll() {
    return this.airportService.getAll();
  }

  @GetMapping("/{id}")
  public Airport getbyId(@PathVariable Integer id) {
    return this.airportService.getById(id);
  }

  @PostMapping("/city/{id}")
  public Airport create(@RequestBody Airport entity, @PathVariable Integer id) {
    return this.airportService.create(entity, id);
  }

  @PutMapping("/{id}")
  public Airport update(@PathVariable Integer id, @RequestBody Airport entity) {
    return this.airportService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.airportService.delete(id);
  }
}
