package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.CityController;
import io.igorv404.flightradarbackjpa.dto.CityDTO;
import io.igorv404.flightradarbackjpa.models.City;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CityDTOAssembler implements RepresentationModelAssembler<City, CityDTO> {
  @Override
  public CityDTO toModel(City entity) {
    CityDTO cityDTO = CityDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .countryName(entity.getCountryName().getName())
            .build();
    Link link = linkTo(methodOn(CityController.class).getById(cityDTO.getId())).withSelfRel();
    cityDTO.add(link);
    return cityDTO;
  }

  @Override
  public CollectionModel<CityDTO> toCollectionModel(Iterable<? extends City> entities) {
    CollectionModel<CityDTO> cityDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(CityController.class).getAll()).withSelfRel();
    cityDTOS.add(links);
    return cityDTOS;
  }
}
