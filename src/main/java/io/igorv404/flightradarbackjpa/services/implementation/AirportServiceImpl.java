package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Airport;
import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.repositories.AirportRepository;
import io.igorv404.flightradarbackjpa.repositories.CityRepository;
import io.igorv404.flightradarbackjpa.services.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
  private final AirportRepository airportRepository;
  private final CityRepository cityRepository;

  public AirportServiceImpl(AirportRepository airportRepository, CityRepository cityRepository) {
    this.airportRepository = airportRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  public List<Airport> getAll() {
    return this.airportRepository.findAll();
  }

  @Override
  public Airport getById(Integer id) {
    return this.airportRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Airport create(Airport entity, Integer cityId) {
    City city = this.cityRepository.findById(cityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setCityId(city);
    return this.airportRepository.save(entity);
  }

  @Override
  public Airport update(Integer id, Airport entity) {
    Airport updatedEntity = this.airportRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setName(entity.getName());
    updatedEntity.setCityId(entity.getCityId());
    return this.airportRepository.save(updatedEntity);
  }

  @Override
  public String delete(Integer id) {
    this.airportRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
