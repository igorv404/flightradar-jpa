package io.igorv404.flightradarbackjpa.repositories;

import io.igorv404.flightradarbackjpa.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {}
