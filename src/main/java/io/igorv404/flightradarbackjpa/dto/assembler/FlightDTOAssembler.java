package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.FlightController;
import io.igorv404.flightradarbackjpa.dto.FlightDTO;
import io.igorv404.flightradarbackjpa.models.Flight;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FlightDTOAssembler implements RepresentationModelAssembler<Flight, FlightDTO> {
  @Override
  public FlightDTO toModel(Flight entity) {
    FlightDTO flightDTO = FlightDTO.builder()
            .id(entity.getId())
            .pilotId(entity.getPilotId().getId())
            .planeId(entity.getPlaneId().getId())
            .startTerminal(entity.getStartTerminal().getId())
            .endTerminal(entity.getEndTerminal().getId())
            .data(entity.getData())
            .time(entity.getTime())
            .price(entity.getPrice())
            .build();
    Link link = linkTo(methodOn(FlightController.class).getById(entity.getId())).withSelfRel();
    flightDTO.add(link);
    return flightDTO;
  }

  @Override
  public CollectionModel<FlightDTO> toCollectionModel(Iterable<? extends Flight> entities) {
    CollectionModel<FlightDTO> flightDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(FlightController.class).getAll()).withSelfRel();
    flightDTOS.add(links);
    return flightDTOS;
  }
}
