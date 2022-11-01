package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.services.CityService;
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

  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping
  public List<City> getAll() {
    return this.cityService.getAll();
  }

  @GetMapping("/{id}")
  public City getById(@PathVariable Integer id) {
    return this.cityService.getById(id);
  }

  @GetMapping("/country/{name}")
  public List<City> getAllByCountryName(@PathVariable String name) {
    return this.cityService.getAllByCountryName(name);
  }

  @PostMapping("/{countryName}")
  public City createWithCountryName(@RequestBody City entity, @PathVariable String countryName) {
    return this.cityService.create(entity, countryName);
  }

  @PutMapping("/{id}")
  public City update(@PathVariable Integer id, @RequestBody City entity) {
    return this.cityService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.cityService.delete(id);
  }
}
