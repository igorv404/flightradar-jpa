package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Model;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface ModelService extends ServiceTemplate<Model, String> {
  Model create(Model entity);
}
