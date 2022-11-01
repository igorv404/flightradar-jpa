package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Pilot;
import io.igorv404.flightradarbackjpa.services.PilotService;
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
@RequestMapping("/pilots")
public class PilotController {
  private final PilotService pilotService;

  public PilotController(PilotService pilotService) {
    this.pilotService = pilotService;
  }

  @GetMapping
  public List<Pilot> getAll() {
    return this.pilotService.getAll();
  }

  @GetMapping("/{id}")
  public Pilot getById(@PathVariable Integer id) {
    return this.pilotService.getById(id);
  }

  @GetMapping("/name/{name}")
  public List<Pilot> getAllByName(@PathVariable String name) {
    return this.pilotService.getAllByName(name);
  }

  @GetMapping("/surname/{surname}")
  public List<Pilot> getAllBySurname(@PathVariable String surname) {
    return this.pilotService.getAllBySurname(surname);
  }

  @PostMapping
  public Pilot create(@RequestBody Pilot entity) {
    return this.pilotService.create(entity);
  }

  @PutMapping("/{id}")
  public Pilot update(@PathVariable Integer id, @RequestBody Pilot entity) {
    return this.pilotService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.pilotService.delete(id);
  }
}
