package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Airport;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface AirportService extends ServiceTemplate<Airport, Integer> {
  Airport create(Airport entity, Integer cityId);
}
