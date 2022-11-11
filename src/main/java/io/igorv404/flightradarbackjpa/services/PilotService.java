package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Pilot;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

import java.util.List;

public interface PilotService extends ServiceTemplate<Pilot, Integer> {
  Pilot create(Pilot entity);
  List<Pilot> getAllByName(String name);

  List<Pilot> getAllBySurname(String surname);

  void createDB();
}
