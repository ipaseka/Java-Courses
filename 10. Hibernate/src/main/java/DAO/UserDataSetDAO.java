package DAO;

import DataSet.UserDataSet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDataSetDAO {
    private Session session;

    public UserDataSetDAO(Session s){
        session = s;
    }
    public void save(UserDataSet userDataSet) {
        session.save(userDataSet);
    }
    public UserDataSet getById(long id) {
        return session.load(UserDataSet.class, id);
    }
    public List<UserDataSet> getByName(String name) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataSet> criteriaQuery = criteriaBuilder.createQuery(UserDataSet.class);
        Root<UserDataSet> root = criteriaQuery.from(UserDataSet.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        Query<UserDataSet> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
    public List<UserDataSet> getAll() {
        CriteriaQuery<UserDataSet> criteriaQuery =  session.getCriteriaBuilder().createQuery(UserDataSet.class);
        criteriaQuery.from(UserDataSet.class);
        return session.createQuery(criteriaQuery).list();
    }
}
