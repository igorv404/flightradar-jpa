package io.igorv404.flightradarbackjpa.services;

import io.igorv404.flightradarbackjpa.models.Company;
import io.igorv404.flightradarbackjpa.templates.ServiceTemplate;

public interface CompanyService extends ServiceTemplate<Company, String> {
  Company create(Company entity, String countyName);
}
