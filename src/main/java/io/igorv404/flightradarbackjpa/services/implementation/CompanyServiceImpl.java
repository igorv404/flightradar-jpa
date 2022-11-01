package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Company;
import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.repositories.CompanyRepository;
import io.igorv404.flightradarbackjpa.repositories.CountryRepository;
import io.igorv404.flightradarbackjpa.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;
  private final CountryRepository countryRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository, CountryRepository countryRepository) {
    this.companyRepository = companyRepository;
    this.countryRepository = countryRepository;
  }

  @Override
  public Company create(Company entity, String countyName) {
    Country country = this.countryRepository.findById(countyName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setCountryName(country);
    return this.companyRepository.save(entity);
  }

  @Override
  public List<Company> getAll() {
    return this.companyRepository.findAll();
  }

  @Override
  public Company getById(String id) {
    return this.companyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Company update(String id, Company entity) {
    Company updatedEntity = this.companyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setCountryName(entity.getCountryName());
    updatedEntity.setCountOfPlane(entity.getCountOfPlane());
    return this.companyRepository.save(updatedEntity);
  }

  @Override
  public String delete(String id) {
    this.companyRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
