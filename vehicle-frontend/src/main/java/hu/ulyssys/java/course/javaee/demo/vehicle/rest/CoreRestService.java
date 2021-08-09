package hu.ulyssys.java.course.javaee.demo.vehicle.rest;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.javaee.demo.vehicle.rest.model.CoreRestModel;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class CoreRestService<T extends AbstractVehicle, M extends CoreRestModel> {
    @Inject
    OwnerService ownerService;
    @Inject
    private CoreService<T> coreService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }

    public abstract M createModelFromEntity(T entity);

    public abstract M initNewModel();

    public List<M> getModelList(Set<T> set){
        List<M> list = new ArrayList<>();
        for(T entity : set){
            list.add(createModelFromEntity(entity)) ;
        }
        return list;
    }

}
