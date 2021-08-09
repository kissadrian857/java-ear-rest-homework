package hu.ulyssys.java.course.javaee.demo.vehicle.rest;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.CarModel;

import javax.ws.rs.Path;

@Path("/car-rest")
public class CarRestService extends CoreRestService<Car, CarModel>{
    @Override
    public CarModel initNewModel() {
        return new CarModel();
    }

    @Override
    public CarModel createModelFromEntity(Car entity) {
        CarModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setOwnerId(entity.getOwner().getId());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        model.setDoorNumbers(entity.getDoorNumbers());
        return model;
    }
}
