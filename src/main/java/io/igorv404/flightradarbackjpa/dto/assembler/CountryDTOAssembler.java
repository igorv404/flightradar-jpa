package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.CountryController;
import io.igorv404.flightradarbackjpa.dto.CountryDTO;
import io.igorv404.flightradarbackjpa.models.Country;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryDTOAssembler implements RepresentationModelAssembler<Country, CountryDTO> {
  @Override
  public CountryDTO toModel(Country entity) {
    CountryDTO countryDTO = CountryDTO.builder()
            .name(entity.getName())
            .build();
    Link link = linkTo(methodOn(CountryController.class).getById(countryDTO.getName())).withSelfRel();
    countryDTO.add(link);
    return countryDTO;
  }

  @Override
  public CollectionModel<CountryDTO> toCollectionModel(Iterable<? extends Country> entities) {
    CollectionModel<CountryDTO> countryDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(CountryController.class).getAll()).withSelfRel();
    countryDTOS.add(links);
    return countryDTOS;
  }
}
