package io.igorv404.flightradarbackjpa.controllers;

import io.igorv404.flightradarbackjpa.models.Terminal;
import io.igorv404.flightradarbackjpa.services.TerminalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminals")
public class TerminalController {
  private final TerminalService terminalService;

  public TerminalController(TerminalService terminalService) {
    this.terminalService = terminalService;
  }

  @GetMapping
  public List<Terminal> getAll() {
    return this.terminalService.getAll();
  }

  @GetMapping("/{id}")
  public Terminal getById(@PathVariable Integer id) {
    return this.terminalService.getById(id);
  }

  @PostMapping("/airport/{id}")
  public Terminal create(@RequestBody Terminal entity, @PathVariable Integer id) {
    return this.terminalService.create(entity, id);
  }

  @PutMapping("/{id}")
  public Terminal update(@PathVariable Integer id, @RequestBody Terminal entity) {
    return this.terminalService.update(id, entity);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return this.terminalService.delete(id);
  }
}
