package io.igorv404.flightradarbackjpa.dto.assembler;

import io.igorv404.flightradarbackjpa.controllers.ModelController;
import io.igorv404.flightradarbackjpa.dto.ModelDTO;
import io.igorv404.flightradarbackjpa.models.Model;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ModelDTOAssembler implements RepresentationModelAssembler<Model, ModelDTO> {
  @Override
  public ModelDTO toModel(Model entity) {
    ModelDTO modelDTO = ModelDTO.builder()
            .name(entity.getName())
            .length(entity.getLength())
            .wingspan(entity.getWingspan())
            .countOfSeats(entity.getCountOfSeats())
            .build();
    Link link = linkTo(methodOn(ModelController.class).getById(entity.getName())).withSelfRel();
    modelDTO.add(link);
    return modelDTO;
  }

  @Override
  public CollectionModel<ModelDTO> toCollectionModel(Iterable<? extends Model> entities) {
    CollectionModel<ModelDTO> modelDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
    Link links = linkTo(methodOn(ModelController.class).getAll()).withSelfRel();
    modelDTOS.add(links);
    return modelDTOS;
  }
}
