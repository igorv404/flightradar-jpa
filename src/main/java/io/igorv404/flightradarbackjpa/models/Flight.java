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
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "pilot_id", referencedColumnName = "id")
  private Pilot pilotId;

  @ManyToOne
  @JoinColumn(name = "plane_id", referencedColumnName = "id")
  private Plane planeId;

  @ManyToOne
  @JoinColumn(name = "start_terminal", referencedColumnName = "id")
  private Terminal startTerminal;

  @ManyToOne
  @JoinColumn(name = "end_terminal", referencedColumnName = "id")
  private Terminal endTerminal;

  @Column
  private Date data;

  @Column
  private Time time;

  @Column
  private Integer price;
}
