package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface CountryService extends ServiceTemplate<Country, String> {
  Country create(Country entity);

  void createWithProcedure(String name);
}
