package io.igorv404.flightradarbackjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "country", collectionRelation = "countries")
public class CountryDTO extends RepresentationModel<CountryDTO> {
  private final String name;
}
