package io.igorv404.flightradarbackjpa.services.implementation;

import io.igorv404.flightradarbackjpa.models.Company;
import io.igorv404.flightradarbackjpa.models.Model;
import io.igorv404.flightradarbackjpa.models.Plane;
import io.igorv404.flightradarbackjpa.repositories.CompanyRepository;
import io.igorv404.flightradarbackjpa.repositories.ModelRepository;
import io.igorv404.flightradarbackjpa.repositories.PlaneRepository;
import io.igorv404.flightradarbackjpa.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
  private final PlaneRepository planeRepository;
  private final CompanyRepository companyRepository;
  private final ModelRepository modelRepository;

  public PlaneServiceImpl(PlaneRepository planeRepository, CompanyRepository companyRepository, ModelRepository modelRepository) {
    this.planeRepository = planeRepository;
    this.companyRepository = companyRepository;
    this.modelRepository = modelRepository;
  }

  @Override
  public Plane create(Plane entity, String companyName, String modelName) {
    Company company = this.companyRepository.findById(companyName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Model model = this.modelRepository.findById(companyName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    entity.setCompanyName(company);
    entity.setModelName(model);
    return this.planeRepository.save(entity);
  }

  @Override
  public List<Plane> getAll() {
    return this.planeRepository.findAll();
  }

  @Override
  public Plane getById(Integer id) {
    return this.planeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public Plane update(Integer id, Plane entity) {
    Plane updatedEntity = this.planeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    updatedEntity.setSpeed(entity.getSpeed());
    updatedEntity.setFlightTime(entity.getFlightTime());
    updatedEntity.setModelName(entity.getModelName());
    updatedEntity.setCompanyName(entity.getCompanyName());
    return this.planeRepository.save(updatedEntity);
  }

  @Override
  public String delete(Integer id) {
    this.planeRepository.deleteById(id);
    return String.format("%s%s", id, " was deleted");
  }
}
