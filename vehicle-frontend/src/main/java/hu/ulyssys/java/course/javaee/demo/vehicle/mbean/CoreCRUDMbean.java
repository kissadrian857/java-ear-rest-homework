package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    private List<T> list;
    private T selectedEntity;
    private boolean inFunction = false;

    protected CoreService<T> service;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        setSelectedEntity(initNewEntity());
        setList(service.getAll());
    }

    public void initSave() {
        selectedEntity = initNewEntity();
        inFunction = true;
    }

    public void save() {
        try {
            if (selectedEntity.getId() == null) {
                service.add(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));

            } else {
                service.update(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
            }
            PrimeFaces.current().executeScript("PF('" + dialogName() + "').hide()");
            inFunction = false;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen törlés", null));

        }
    }

    public void remove() {
        try {
            service.remove(selectedEntity);
            list = service.getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen törlés", null));

        }
    }

    protected abstract T initNewEntity();

    protected abstract String dialogName();

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public void setInFunction(boolean inFunction) {
        this.inFunction = inFunction;
    }
}
