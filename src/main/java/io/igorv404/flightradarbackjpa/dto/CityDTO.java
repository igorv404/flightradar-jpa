package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "city", collectionRelation = "cities")
public class CityDTO extends RepresentationModel<CityDTO> {
  private final Integer id;
  private final String name;
  private final String countryName;
}
