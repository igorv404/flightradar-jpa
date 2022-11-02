package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.dto.CompanyDTO;
import io.igorv404.flightradarbackjpa.dto.assembler.CompanyDTOAssembler;
import io.igorv404.flightradarbackjpa.models.Company;
import io.igorv404.flightradarbackjpa.services.CompanyService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
  private final CompanyService companyService;
  public final CompanyDTOAssembler companyDTOAssembler;

  public CompanyController(CompanyService companyService, CompanyDTOAssembler companyDTOAssembler) {
    this.companyService = companyService;
    this.companyDTOAssembler = companyDTOAssembler;
  }

  @GetMapping
  public CollectionModel<CompanyDTO> getAll() {
    List<Company> companies = this.companyService.getAll();
    return this.companyDTOAssembler.toCollectionModel(companies);
  }

  @GetMapping("/{id}")
  public CompanyDTO getById(@PathVariable String id) {
    Company company = this.companyService.getById(id);
    return this.companyDTOAssembler.toModel(company);
  }

  @PostMapping("/country/{name}")
  public CompanyDTO create(@PathVariable String name, @RequestBody Company entity) {
    Company company = this.companyService.create(entity, name);
    return this.companyDTOAssembler.toModel(company);
  }

  @PutMapping("/{id}")
  public CompanyDTO update(@PathVariable String id, @RequestBody Company entity) {
    Company company = this.companyService.update(id, entity);
    return this.companyDTOAssembler.toModel(company);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.companyService.delete(id);
  }
}
