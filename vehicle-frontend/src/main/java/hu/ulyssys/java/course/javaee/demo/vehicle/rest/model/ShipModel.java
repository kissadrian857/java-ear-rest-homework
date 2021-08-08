package hu.ulyssys.java.course.javaee.demo.vehicle.rest.model;

public class ShipModel extends CoreRestModel{
    private String licensePlateNumber;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
}
