package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Flight;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface FlightService extends ServiceTemplate<Flight, Integer> {
  Flight create(Flight entity, Integer pilotId, Integer planeId, Integer startTerminalId, Integer endTerminalId);
}
