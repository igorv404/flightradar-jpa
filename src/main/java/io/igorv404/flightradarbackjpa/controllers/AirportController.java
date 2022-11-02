package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.AirportDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.AirportDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Airport;
import io.igorv404.flightradarbackjpa.services.AirportService;
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
@RequestMapping("/airports")
public class AirportController {
  private final AirportService airportService;
  public final AirportDTOAssembler airportDTOAssembler;

  public AirportController(AirportService airportService, AirportDTOAssembler airportDTOAssembler) {
    this.airportService = airportService;
    this.airportDTOAssembler = airportDTOAssembler;
  }

  @GetMapping
  public CollectionModel<AirportDTO> getAll() {
    List<Airport> airports = this.airportService.getAll();
    return this.airportDTOAssembler.toCollectionModel(airports);
  }

  @GetMapping("/{id}")
  public AirportDTO getbyId(@PathVariable Integer id) {
    Airport airport = this.airportService.getById(id);
    return this.airportDTOAssembler.toModel(airport);
  }

  @PostMapping("/city/{id}")
  public AirportDTO create(@RequestBody Airport entity, @PathVariable Integer id) {
    Airport airport = this.airportService.create(entity, id);
    return this.airportDTOAssembler.toModel(airport);
  }

  @PutMapping("/{id}")
  public AirportDTO update(@PathVariable Integer id, @RequestBody Airport entity) {
    Airport airport = this.airportService.update(id, entity);
    return this.airportDTOAssembler.toModel(airport);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.airportService.delete(id);
  }
}
