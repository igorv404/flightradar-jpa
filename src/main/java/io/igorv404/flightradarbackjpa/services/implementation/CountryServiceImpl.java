package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.repositories.CountryRepository;
import io.igorv404.flightradarbackjpa.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
  private final CountryRepository countryRepository;

  public CountryServiceImpl(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Override
  public List<Country> getAll() {
    return this.countryRepository.findAll();
  }

  @Override
  public Country getById(String id) {
    return this.countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Country create(Country entity) {
    return this.countryRepository.save(entity);
  }

  @Override
  @Transactional
  public Country update(String id, Country entity) {
    Country updatedEntity = this.countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setName(entity.getName());
    return this.countryRepository.save(updatedEntity);
  }

  @Override
  public String delete(String id) {
    this.countryRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
