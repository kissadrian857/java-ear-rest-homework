package hu.ulyssys.java.course.javaee.demo.vehicle.rest.model;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;

import javax.ws.rs.core.GenericEntity;
import java.util.Set;

public class OwnerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private GenericEntity<Set<Car>> cars;
    private GenericEntity<Set<Ship>> ships;
    private GenericEntity<Set<Plane>> planes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenericEntity<Set<Car>> getCars() {
        return cars;
    }

    public void setCars(GenericEntity<Set<Car>> cars) {
        this.cars = cars;
    }

    public GenericEntity<Set<Ship>> getShips() {
        return ships;
    }

    public void setShips(GenericEntity<Set<Ship>> ships) {
        this.ships = ships;
    }

    public GenericEntity<Set<Plane>> getPlanes() {
        return planes;
    }

    public void setPlanes(GenericEntity<Set<Plane>> planes) {
        this.planes = planes;
    }
}
