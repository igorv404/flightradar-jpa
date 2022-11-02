package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.CityDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.CityDTOAssembler;
import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.services.CityService;
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
@RequestMapping("/cities")
public class CityController {
  private final CityService cityService;
  private final CityDTOAssembler cityDTOAssembler;

  public CityController(CityService cityService, CityDTOAssembler cityDTOAssembler) {
    this.cityService = cityService;
    this.cityDTOAssembler = cityDTOAssembler;
  }

  @GetMapping
  public CollectionModel<CityDTO> getAll() {
    List<City> cities = this.cityService.getAll();
    return this.cityDTOAssembler.toCollectionModel(cities);
  }

  @GetMapping("/{id}")
  public CityDTO getById(@PathVariable Integer id) {
    City city = this.cityService.getById(id);
    return this.cityDTOAssembler.toModel(city);
  }

  @GetMapping("/country/{name}")
  public CollectionModel<CityDTO> getAllByCountryName(@PathVariable String name) {
    List<City> cities = this.cityService.getAllByCountryName(name);
    return this.cityDTOAssembler.toCollectionModel(cities);
  }

  @PostMapping("/{countryName}")
  public CityDTO createWithCountryName(@RequestBody City entity, @PathVariable String countryName) {
    City city = this.cityService.create(entity, countryName);
    return this.cityDTOAssembler.toModel(city);
  }

  @PutMapping("/{id}")
  public CityDTO update(@PathVariable Integer id, @RequestBody City entity) {
    City city = this.cityService.update(id, entity);
    return this.cityDTOAssembler.toModel(city);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.cityService.delete(id);
  }
}
