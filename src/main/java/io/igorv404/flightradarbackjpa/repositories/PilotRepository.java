package io.igorv404.flightradarbackjpa.repositories;

import io.igorv404.flightradarbackjpa.models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {
  List<Pilot> findAllByName(String name);

  List<Pilot> findAllBySurname(String surname);
}
