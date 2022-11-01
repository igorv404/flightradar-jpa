package io.igorv404.flightradarbackjpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
  @Id
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_name", referencedColumnName = "name")
  private Country countryName;

  @Column
  private Integer countOfPlane;
}
