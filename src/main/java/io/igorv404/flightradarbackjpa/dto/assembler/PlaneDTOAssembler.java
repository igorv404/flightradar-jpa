package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.PlaneController;
import io.igorv404.flightradarbackjpa.dto.PlaneDTO;
import io.igorv404.flightradarbackjpa.models.Plane;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlaneDTOAssembler implements RepresentationModelAssembler<Plane, PlaneDTO> {
  @Override
  public PlaneDTO toModel(Plane entity) {
    PlaneDTO planeDTO = PlaneDTO.builder()
            .id(entity.getId())
            .modelName(entity.getModelName().getName())
            .companyName(entity.getCompanyName().getName())
            .speed(entity.getSpeed())
            .flightTime(entity.getFlightTime())
            .build();
    Link link = linkTo(methodOn(PlaneController.class).getById(entity.getId())).withSelfRel();
    planeDTO.add(link);
    return planeDTO;
  }

  @Override
  public CollectionModel<PlaneDTO> toCollectionModel(Iterable<? extends Plane> entities) {
    CollectionModel<PlaneDTO> planeDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(PlaneController.class).getAll()).withSelfRel();
    planeDTOS.add(links);
    return planeDTOS;
  }
}
