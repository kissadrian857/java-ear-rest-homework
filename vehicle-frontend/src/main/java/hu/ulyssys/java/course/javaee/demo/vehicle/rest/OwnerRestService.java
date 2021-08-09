package hu.ulyssys.java.course.javaee.demo.vehicle.rest;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.CoreRestModel;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.OwnerModel;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/owner")
public class OwnerRestService {
    @Inject
    OwnerService ownerService;
    CarRestService carRestService = new CarRestService();
    PlaneRestService planeRestService = new PlaneRestService();
    ShipRestService shipRestService = new ShipRestService();

    @GET
    @Path("/{id}")
    public Response getAllVehicles(@PathParam("id") Long id) {
        List<CoreRestModel> vehicles = new ArrayList<>();
        Owner owner = ownerService.findById(id);
        for (Car car : owner.getCars()) {
            vehicles.add(carRestService.createModelFromEntity(car));
        }
        for (Ship ship : owner.getShips()) {
            vehicles.add(shipRestService.createModelFromEntity(ship));
        }
        for (Plane plane : owner.getPlanes()) {
            vehicles.add(planeRestService.createModelFromEntity(plane));
        }
        GenericEntity<List<CoreRestModel>> genericEntity = new GenericEntity<>(vehicles) {
        };

        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/data/{id}")
    public Response getOwnerData(@PathParam("id") Long id) {
        Owner owner = ownerService.findById(id);
        if(owner == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        OwnerModel model = new OwnerModel();
        model.setId(owner.getId());
        model.setFirstName(owner.getFirstName());
        model.setLastName(owner.getLastName());
        model.setCars(carRestService.getModelList(owner.getCars()));
        model.setPlanes(planeRestService.getModelList(owner.getPlanes()));
        model.setShips(shipRestService.getModelList(owner.getShips()));
        return Response.ok(model).build();
    }
}
