package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Pilot;
import io.igorv404.flightradarbackjpa.repositories.PilotRepository;
import io.igorv404.flightradarbackjpa.services.PilotService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PilotServiceImpl implements PilotService {
  private final PilotRepository pilotRepository;

  public PilotServiceImpl(PilotRepository pilotRepository) {
    this.pilotRepository = pilotRepository;
  }

  @Override
  public List<Pilot> getAllByName(String name) {
    return this.pilotRepository.findAllByName(name);
  }

  @Override
  public List<Pilot> getAllBySurname(String surname) {
    return this.pilotRepository.findAllBySurname(surname);
  }

  @Override
  public void createDB() {
    this.pilotRepository.createDB();
  }

  @Override
  public List<Pilot> getAll() {
    return this.pilotRepository.findAll();
  }

  @Override
  public Pilot getById(Integer id) {
    return this.pilotRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Pilot create(Pilot entity) {
    return this.pilotRepository.save(entity);
  }

  @Override
  @Transactional
  public Pilot update(Integer id, Pilot entity) {
    Pilot updatedEntity = this.pilotRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setName(entity.getName());
    updatedEntity.setSurname(entity.getSurname());
    updatedEntity.setAge(entity.getAge());
    updatedEntity.setFlightExperience(entity.getFlightExperience());
    return this.pilotRepository.save(updatedEntity);
  }

  @Override
  public String delete(Integer id) {
    this.pilotRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
