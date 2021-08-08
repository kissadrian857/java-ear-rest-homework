package hu.ulyssys.java.course.javaee.demo.vehicle.service;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import java.util.List;

public interface OwnerService extends CoreService<Owner> {
    Owner findByName(String firstName,String lastName);
}
