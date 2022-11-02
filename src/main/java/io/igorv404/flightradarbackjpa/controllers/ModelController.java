package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.ModelDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.ModelDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Model;
import io.igorv404.flightradarbackjpa.services.ModelService;
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
@RequestMapping("/models")
public class ModelController {

  private final ModelService modelService;
  private final ModelDTOAssembler modelDTOAssembler;

  public ModelController(ModelService modelService, ModelDTOAssembler modelDTOAssembler) {
    this.modelService = modelService;
    this.modelDTOAssembler = modelDTOAssembler;
  }

  @GetMapping
  public CollectionModel<ModelDTO> getAll() {
    List<Model> models = this.modelService.getAll();
    return this.modelDTOAssembler.toCollectionModel(models);
  }

  @GetMapping("/{id}")
  public ModelDTO getById(@PathVariable String id) {
    Model model = this.modelService.getById(id);
    return this.modelDTOAssembler.toModel(model);
  }

  @PostMapping
  public ModelDTO create(@RequestBody Model entity) {
    Model model = this.modelService.create(entity);
    return this.modelDTOAssembler.toModel(model);
  }

  @PutMapping("/{id}")
  public ModelDTO update(@PathVariable String id, @RequestBody Model entity) {
    Model model = this.modelService.update(id, entity);
    return this.modelDTOAssembler.toModel(model);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.modelService.delete(id);
  }
}
