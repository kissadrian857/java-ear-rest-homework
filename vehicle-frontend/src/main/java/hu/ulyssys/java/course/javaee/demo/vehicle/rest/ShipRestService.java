package hu.ulyssys.java.course.javaee.demo.vehicle.rest;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.ShipModel;

import javax.ws.rs.Path;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel> {
    @Override
    protected ShipModel createModelFromEntity(Ship entity) {
        ShipModel model = initNewModel();
        model.setId(entity.getId());
        model.setType(entity.getType());
        model.setManufacturer(entity.getManufacturer());
        model.setOwnerId(entity.getOwner().getId());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        return model;
    }

    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }
}
