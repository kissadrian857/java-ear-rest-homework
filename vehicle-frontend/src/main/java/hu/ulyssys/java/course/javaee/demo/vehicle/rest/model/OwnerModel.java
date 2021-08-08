package hu.ulyssys.java.course.javaee.demo.vehicle.rest.model;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;

import java.util.Set;

public class OwnerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Car> cars;
    private Set<Plane> planes;
    private Set<Ship> ships;

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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }
}
