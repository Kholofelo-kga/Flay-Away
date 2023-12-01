
package com.kholo.FlyAway.models;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;

    private String airlineName;


    public Airline() {
    }

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
