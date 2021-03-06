package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vehicle_owner")
public class Owner extends AbstractEntity {
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Car> cars;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Plane> planes;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Ship> ships;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    //TODO change the definition to contain the id component of the superclass


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;
        if (getId() != null ? !getId().equals(owner.getId()) : owner.getId() != null) return false;
        return firstName != null ? firstName.equals(owner.firstName) : owner.firstName == null &&
                lastName != null ? lastName.equals(owner.lastName) : owner.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0) +
                (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
