package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.ShipService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ShipCRUDMbean extends OwnerAwareCRUDMbean<Ship> implements Serializable {
    @Inject
    public ShipCRUDMbean(CoreService<Ship> service, OwnerService ownerService) {
        super(service, ownerService);
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }

    @Override
    protected String dialogName() {
        return "shipDialog";
    }

    //    private List<Ship> list;
//    private Ship selectedShip;
//    private boolean inFunction;
//    private List<Owner> ownerList;
//
//    @Inject
//    private ShipService shipService;
//    @Inject
//    private OwnerService ownerService;
//
//    @PostConstruct
//    private void init() {
//        list = shipService.getAll();
//        ownerList = ownerService.getAll();
//        //Reflection
//        selectedShip = new Ship();
//    }
//
//    public void initSave() {
//        selectedShip = new Ship();
//        inFunction = true;
//    }
//
//    public void initEdit() {
//        inFunction = true;
//    }
//
//    public void save() {
//        if (selectedShip.getId() == null) {
//            shipService.add(selectedShip);
//            list = shipService.getAll();
//            selectedShip = new Ship();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozz??ad??s"));
//
//        } else {
//            shipService.update(selectedShip);
//            list = shipService.getAll();
//            selectedShip = new Ship();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres m??dos??t??s"));
//
//        }
//        PrimeFaces.current().executeScript("PF('shipDialog').hide()");
//    }
//
//    public void remove() {
//        shipService.remove(selectedShip);
//        list = shipService.getAll();
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres t??rl??s"));
//        inFunction = false;
//        selectedShip = new Ship();
//    }
//
//    public List<Owner> getOwnerList() {
//        return ownerList;
//    }
//
//    public void setOwnerList(List<Owner> ownerList) {
//        this.ownerList = ownerList;
//    }
//
//    public List<Ship> getList() {
//        return list;
//    }
//
//    public void setList(List<Ship> list) {
//        this.list = list;
//    }
//
//    public Ship getSelectedShip() {
//        return selectedShip;
//    }
//
//    public void setSelectedShip(Ship selectedShip) {
//        this.selectedShip = selectedShip;
//    }
//
//    public boolean isInFunction() {
//        return inFunction;
//    }
}
