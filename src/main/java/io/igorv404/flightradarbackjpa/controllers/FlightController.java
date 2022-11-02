package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.FlightDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.FlightDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Flight;
import io.igorv404.flightradarbackjpa.services.FlightService;
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
@RequestMapping("/flights")
public class FlightController {
  private final FlightService flightService;
  private final FlightDTOAssembler flightDTOAssembler;

  public FlightController(FlightService flightService, FlightDTOAssembler flightDTOAssembler) {
    this.flightService = flightService;
    this.flightDTOAssembler = flightDTOAssembler;
  }

  @GetMapping
  public CollectionModel<FlightDTO> getAll() {
    List<Flight> flights = this.flightService.getAll();
    return this.flightDTOAssembler.toCollectionModel(flights);
  }

  @GetMapping("/{id}")
  public FlightDTO getById(@PathVariable Integer id) {
    Flight flight =  this.flightService.getById(id);
    return this.flightDTOAssembler.toModel(flight);
  }

  @PostMapping("/{pilotId}/{planeId}/{startId}/{endId}")
  public FlightDTO create(@PathVariable Integer pilotId, @PathVariable Integer planeId, @PathVariable Integer startId, @PathVariable Integer endId, @RequestBody Flight entity) {
    Flight flight =  this.flightService.create(entity, pilotId, planeId, startId, endId);
    return this.flightDTOAssembler.toModel(flight);
  }

  @PutMapping("/{id}")
  public FlightDTO update(@RequestBody Flight entity, @PathVariable Integer id) {
    Flight flight = this.flightService.update(id, entity);
    return this.flightDTOAssembler.toModel(flight);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.flightService.delete(id);
  }
}
