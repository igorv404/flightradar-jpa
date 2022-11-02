package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.PilotController;
import io.igorv404.flightradarbackjpa.dto.PilotDTO;
import io.igorv404.flightradarbackjpa.models.Pilot;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PilotDTOAssembler implements RepresentationModelAssembler<Pilot, PilotDTO> {
  @Override
  public PilotDTO toModel(Pilot entity) {
    PilotDTO pilotDTO = PilotDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .surname(entity.getSurname())
            .age(entity.getAge())
            .flightExperience(entity.getFlightExperience())
            .build();
    Link link = linkTo(methodOn(PilotController.class).getById(entity.getId())).withSelfRel();
    pilotDTO.add(link);
    return pilotDTO;
  }

  @Override
  public CollectionModel<PilotDTO> toCollectionModel(Iterable<? extends Pilot> entities) {
    CollectionModel<PilotDTO> pilotDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(PilotController.class).getAll()).withSelfRel();
    pilotDTOS.add(links);
    return pilotDTOS;
  }
}
