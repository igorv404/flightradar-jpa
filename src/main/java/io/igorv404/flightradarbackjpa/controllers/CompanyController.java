package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Company;
import io.igorv404.flightradarbackjpa.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping
  public List<Company> getAll() {
    return this.companyService.getAll();
  }

  @GetMapping("/{id}")
  public Company getById(@PathVariable String id) {
    return this.companyService.getById(id);
  }

  @PostMapping("/country/{name}")
  public Company create(@PathVariable String name, @RequestBody Company entity) {
    return this.companyService.create(entity, name);
  }

  @PutMapping("/{id}")
  public Company update(@PathVariable String id, @RequestBody Company entity) {
    return this.companyService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) {
    return this.companyService.delete(id);
  }
}
