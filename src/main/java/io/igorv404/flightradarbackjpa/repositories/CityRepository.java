package io.igorv404.flightradarbackjpa.repositories;

import io.igorv404.flightradarbackjpa.models.City;
import io.igorv404.flightradarbackjpa.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
  List<City> findAllByCountryName(Country countryName);
}
