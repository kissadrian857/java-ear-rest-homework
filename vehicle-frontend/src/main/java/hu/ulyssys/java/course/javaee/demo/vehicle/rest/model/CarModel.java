package hu.ulyssys.java.course.javaee.demo.vehicle.rest.model;

import javax.validation.constraints.Max;

public class CarModel extends CoreRestModel{
    private String licensePlateNumber;
    @Max(value = 4)
    private int doorNumbers;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }
}
