package io.igorv404.flightradarbackjpa.repositories;

import io.igorv404.flightradarbackjpa.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {}
