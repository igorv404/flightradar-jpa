package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.models.Country;
import io.igorv404.flightradarbackjpa.repositories.CityRepository;
import io.igorv404.flightradarbackjpa.repositories.CountryRepository;
import io.igorv404.flightradarbackjpa.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
  private final CityRepository cityRepository;
  private final CountryRepository countryRepository;

  public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
    this.cityRepository = cityRepository;
    this.countryRepository = countryRepository;
  }

  @Override
  public List<City> getAllByCountryName(String id) {
    Country country = this.countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    return this.cityRepository.findAllByCountryName(country);
  }

  @Override
  public List<City> getAll() {
    return this.cityRepository.findAll();
  }

  @Override
  public City getById(Integer id) {
    return this.cityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  @Transactional
  public City create(City entity, String countryName) {
    Country country = this.countryRepository.findById(countryName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setCountryName(country);
    return this.cityRepository.save(entity);
  }

  @Override
  public City update(Integer id, City entity) {
    City updatedEntity = this.cityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setName(entity.getName());
    updatedEntity.setCountryName(entity.getCountryName());
    return this.cityRepository.save(updatedEntity);
  }

  @Override
  public String delete(Integer id) {
    this.cityRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
