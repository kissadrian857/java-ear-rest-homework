package hu.ulyssys.java.course.javaee.demo.vehicle.rest;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.PlaneModel;

import javax.ws.rs.Path;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel> {
    @Override
    protected PlaneModel createModelFromEntity(Plane entity) {
       PlaneModel model = initNewModel();
       model.setId(entity.getId());
       model.setManufacturer(entity.getManufacturer());
       model.setPassengerNumber(entity.getPassengerNumber());
       model.setType(entity.getType());
       model.setOwnerId(entity.getOwner().getId());
       return model;
    }

    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }
}
