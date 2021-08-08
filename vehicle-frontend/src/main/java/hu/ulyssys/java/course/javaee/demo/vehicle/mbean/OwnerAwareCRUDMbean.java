package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;

import java.util.List;

public abstract class OwnerAwareCRUDMbean<T extends AbstractVehicle> extends CoreCRUDMbean<T> {
    private List<Owner> ownerList;

    public OwnerAwareCRUDMbean(CoreService<T> service, OwnerService ownerService) {
        super(service);
        this.ownerList = ownerService.getAll();
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }
}
