package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.services.CountryService;
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

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public List<Country> getAll() {
    return this.countryService.getAll();
  }

  @GetMapping("/{id}")
  public Country getById(@PathVariable String id) {
    return this.countryService.getById(id);
  }

  @PostMapping
  public Country create(@RequestBody Country entity) {
    return this.countryService.create(entity);
  }

  @PutMapping("/{id}")
  public Country update(@PathVariable String id, @RequestBody Country entity) {
    return this.countryService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.countryService.delete(id);
  }
}
