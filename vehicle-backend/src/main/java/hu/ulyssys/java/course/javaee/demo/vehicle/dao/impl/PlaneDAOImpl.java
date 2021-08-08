package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.PlaneDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;

import javax.ejb.Stateless;

@Stateless
public class PlaneDAOImpl extends CoreDAOImpl<Plane> implements PlaneDAO {

    @Override
    protected Class<Plane> getManagedClass() {
        return Plane.class;
    }
}
