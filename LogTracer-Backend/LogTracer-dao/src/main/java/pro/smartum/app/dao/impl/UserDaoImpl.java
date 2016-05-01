package pro.smartum.app.dao.impl;

import org.springframework.stereotype.Repository;
import pro.smartum.app.dao.BaseDao;
import pro.smartum.app.dao.UserDao;
import pro.smartum.app.model.Application;
import pro.smartum.app.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by eldar.s on 27.04.2016.
 */
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    public UserDaoImpl(){
        setClazz(User.class );
    }

    public User getUserByLoginAndPassword(String login, String password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(
                builder.equal(userRoot.get("login"), login),
                builder.equal(userRoot.get("password"), password)
        );
        TypedQuery<User> query = entityManager.createQuery(criteria);
        List<User> results = query.getResultList();
        if(results.isEmpty())
            return null;
        return results.get(0);
    }


    public User getUserByLogin(String login) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot).where(builder.equal(userRoot.get("login"), login));
        TypedQuery<User> query = entityManager.createQuery(criteria);
        List<User> results = query.getResultList();
        if(results.isEmpty())
            return null;
        return results.get(0);
    }


}
