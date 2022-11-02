package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.AirportController;
import io.igorv404.flightradarbackjpa.dto.AirportDTO;
import io.igorv404.flightradarbackjpa.models.Airport;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AirportDTOAssembler implements RepresentationModelAssembler<Airport, AirportDTO> {
  @Override
  public AirportDTO toModel(Airport entity) {
    AirportDTO airportDTO = AirportDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .cityId(entity.getCityId().getId())
            .build();
    Link link = linkTo(methodOn(AirportController.class).getbyId(airportDTO.getId())).withSelfRel();
    airportDTO.add(link);
    return airportDTO;
  }

  @Override
  public CollectionModel<AirportDTO> toCollectionModel(Iterable<? extends Airport> entities) {
    CollectionModel<AirportDTO> airportDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(AirportController.class).getAll()).withSelfRel();
    airportDTOS.add(links);
    return airportDTOS;
  }
}
