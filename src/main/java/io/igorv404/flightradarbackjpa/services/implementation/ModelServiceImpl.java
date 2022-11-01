package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Model;
import io.igorv404.flightradarbackjpa.repositories.ModelRepository;
import io.igorv404.flightradarbackjpa.services.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
  private final ModelRepository modelRepository;

  public ModelServiceImpl(ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  @Override
  public List<Model> getAll() {
    return this.modelRepository.findAll();
  }

  @Override
  public Model getById(String id) {
    return this.modelRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Model create(Model entity) {
    return this.modelRepository.save(entity);
  }

  @Override
  @Transactional
  public Model update(String id, Model entity) {
    Model updatedEntity = this.modelRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setLength(entity.getLength());
    updatedEntity.setWingspan(entity.getWingspan());
    updatedEntity.setCountOfSeats(entity.getCountOfSeats());
    return this.modelRepository.save(updatedEntity);
  }

  @Override
  public String delete(String id) {
    this.modelRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
