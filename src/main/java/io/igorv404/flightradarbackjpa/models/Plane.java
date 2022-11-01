package io.igorv404.flightradarbackjpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "model_name", referencedColumnName = "name")
  private Model modelName;

  @ManyToOne
  @JoinColumn(name = "company_name", referencedColumnName = "name")
  private Company companyName;

  @Column
  private Integer speed;

  @Column
  private Integer flightTime;
}
