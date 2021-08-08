package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.OwnerDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class OwnerDAOImpl extends CoreDAOImpl<Owner> implements OwnerDAO {

    @Override
    public Owner findByName(String firstName, String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("firstName"), firstName),
                criteriaBuilder.equal(root.get("lastName"), lastName)));
        TypedQuery<Owner> query = entityManager.createQuery(criteriaQuery);

        List<Owner> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected Class<Owner> getManagedClass() {
        return Owner.class;
    }
}
