package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Flight;
import io.igorv404.flightradarbackjpa.services.FlightService;
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
@RequestMapping("/flights")
public class FlightController {
  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping
  public List<Flight> getAll() {
    return this.flightService.getAll();
  }

  @GetMapping("/{id}")
  public Flight getById(@PathVariable Integer id) {
    return this.flightService.getById(id);
  }

  @PostMapping("/{pilotId}/{planeId}/{startId}/{endId}")
  public Flight create(@PathVariable Integer pilotId, @PathVariable Integer planeId, @PathVariable Integer startId, @PathVariable Integer endId, @RequestBody Flight entity) {
    return this.flightService.create(entity, pilotId, planeId, startId, endId);
  }

  @PutMapping("/{id}")
  public Flight update(@RequestBody Flight entity, @PathVariable Integer id) {
    return this.flightService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.flightService.delete(id);
  }
}
