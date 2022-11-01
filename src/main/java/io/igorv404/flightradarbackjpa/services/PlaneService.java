package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Plane;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface PlaneService extends ServiceTemplate<Plane, Integer> {
  Plane create(Plane entity, String companyName, String modelName);
}
