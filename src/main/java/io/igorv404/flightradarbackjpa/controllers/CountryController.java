package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.CountryDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.CountryDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.services.CountryService;
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
@RequestMapping("/countries")
public class CountryController {
  private final CountryService countryService;
  private final CountryDTOAssembler countryDTOAssembler;

  public CountryController(CountryService countryService, CountryDTOAssembler countryDTOAssembler) {
    this.countryService = countryService;
    this.countryDTOAssembler = countryDTOAssembler;
  }

  @GetMapping
  public CollectionModel<CountryDTO> getAll() {
    List<Country> countries = this.countryService.getAll();
    return this.countryDTOAssembler.toCollectionModel(countries);
  }

  @GetMapping("/{id}")
  public CountryDTO getById(@PathVariable String id) {
    Country country = this.countryService.getById(id);
    return this.countryDTOAssembler.toModel(country);
  }

  @PostMapping
  public CountryDTO create(@RequestBody Country entity) {
    Country country = this.countryService.create(entity);
    return this.countryDTOAssembler.toModel(country);
  }

  @PutMapping("/{id}")
  public CountryDTO update(@PathVariable String id, @RequestBody Country entity) {
    Country country = this.countryService.update(id, entity);
    return this.countryDTOAssembler.toModel(country);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.countryService.delete(id);
  }
}
