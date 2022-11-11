package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

import java.util.List;

public interface CityService extends ServiceTemplate<City, Integer> {
  City create(City entity, String countryName);
  List<City> getAllByCountryName(String id);

  void createTenCities(String name);
}
