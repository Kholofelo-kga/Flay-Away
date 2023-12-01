package com.kholo.FlyAway.models;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @ManyToOne
    private Place source;

    @ManyToOne
    private Place destination;

    @ManyToOne
    private Airline airline;

    private double ticketPrice;


    public Flight() {
    }

    public Flight(Place source, Place destination, Airline airline, double ticketPrice) {
        this.source = source;
        this.destination = destination;
        this.airline = airline;
        this.ticketPrice = ticketPrice;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Place getSource() {
        return source;
    }

    public void setSource(Place source) {
        this.source = source;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
