package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Terminal;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface TerminalService extends ServiceTemplate<Terminal, Integer> {
  Terminal create(Terminal entity, Integer airportId);
}
