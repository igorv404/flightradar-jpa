package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.TerminalController;
import io.igorv404.flightradarbackjpa.dto.TerminalDTO;
import io.igorv404.flightradarbackjpa.models.Terminal;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TerminalDTOAssembler implements RepresentationModelAssembler<Terminal, TerminalDTO> {
  @Override
  public TerminalDTO toModel(Terminal entity) {
    TerminalDTO terminalDTO = TerminalDTO.builder()
            .id(entity.getId())
            .number(entity.getNumber())
            .airportId(entity.getAirportId().getId())
            .build();
    Link link = linkTo(methodOn(TerminalController.class).getById(entity.getId())).withSelfRel();
    terminalDTO.add(link);
    return terminalDTO;
  }

  @Override
  public CollectionModel<TerminalDTO> toCollectionModel(Iterable<? extends Terminal> entities) {
    CollectionModel<TerminalDTO> terminalDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(TerminalController.class).getAll()).withSelfRel();
    terminalDTOS.add(links);
    return terminalDTOS;
  }
}
