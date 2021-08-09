package hu.ulyssys.java.course.javaee.demo.vehicle.rest.model;

import java.util.List;

public class OwnerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private List<CarModel> cars;
    private List<ShipModel> ships;
    private List<PlaneModel> planes;

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

    public List<CarModel> getCars() {
        return cars;
    }

    public void setCars(List<CarModel> cars) {
        this.cars = cars;
    }

    public List<ShipModel> getShips() {
        return ships;
    }

    public void setShips(List<ShipModel> ships) {
        this.ships = ships;
    }

    public List<PlaneModel> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneModel> planes) {
        this.planes = planes;
    }
}
