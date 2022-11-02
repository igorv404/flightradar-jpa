package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.CompanyController;
import io.igorv404.flightradarbackjpa.dto.CompanyDTO;
import io.igorv404.flightradarbackjpa.models.Company;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CompanyDTOAssembler implements RepresentationModelAssembler<Company, CompanyDTO> {
  @Override
  public CompanyDTO toModel(Company entity) {
    CompanyDTO companyDTO = CompanyDTO.builder()
            .name(entity.getName())
            .countryName(entity.getCountryName().getName())
            .countOfPlane(entity.getCountOfPlane())
            .build();
    Link link = linkTo(methodOn(CompanyController.class).getById(entity.getName())).withSelfRel();
    companyDTO.add(link);
    return companyDTO;
  }

  @Override
  public CollectionModel<CompanyDTO> toCollectionModel(Iterable<? extends Company> entities) {
    CollectionModel<CompanyDTO> companyDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(CompanyController.class).getAll()).withSelfRel();
    companyDTOS.add(links);
    return companyDTOS;
  }
}
