package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.PilotDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.PilotDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Pilot;
import io.igorv404.flightradarbackjpa.services.PilotService;
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
@RequestMapping("/pilots")
public class PilotController {
  private final PilotService pilotService;
  private final PilotDTOAssembler pilotDTOAssembler;

  public PilotController(PilotService pilotService, PilotDTOAssembler pilotDTOAssembler) {
    this.pilotService = pilotService;
    this.pilotDTOAssembler = pilotDTOAssembler;
  }

  @GetMapping
  public CollectionModel<PilotDTO> getAll() {
    List<Pilot> pilots = this.pilotService.getAll();
    return this.pilotDTOAssembler.toCollectionModel(pilots);
  }

  @GetMapping("/{id}")
  public PilotDTO getById(@PathVariable Integer id) {
    Pilot pilot = this.pilotService.getById(id);
    return this.pilotDTOAssembler.toModel(pilot);
  }

  @GetMapping("/name/{name}")
  public CollectionModel<PilotDTO> getAllByName(@PathVariable String name) {
    List<Pilot> pilots = this.pilotService.getAllByName(name);
    return this.pilotDTOAssembler.toCollectionModel(pilots);
  }

  @GetMapping("/surname/{surname}")
  public CollectionModel<PilotDTO> getAllBySurname(@PathVariable String surname) {
    List<Pilot> pilots = this.pilotService.getAllBySurname(surname);
    return this.pilotDTOAssembler.toCollectionModel(pilots);
  }

  @PostMapping
  public PilotDTO create(@RequestBody Pilot entity) {
    Pilot pilot = this.pilotService.create(entity);
    return this.pilotDTOAssembler.toModel(pilot);
  }

  @PutMapping("/{id}")
  public PilotDTO update(@PathVariable Integer id, @RequestBody Pilot entity) {
    Pilot pilot = this.pilotService.update(id, entity);
    return this.pilotDTOAssembler.toModel(pilot);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.pilotService.delete(id);
  }
}
