package pro.smartum.app.dao.impl;

import org.springframework.stereotype.Repository;
import pro.smartum.app.dao.ApplicationDao;
import pro.smartum.app.dao.BaseDao;
import pro.smartum.app.model.Application;

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
public class ApplicationDaoImpl extends BaseDao<Application> implements ApplicationDao{
    private static final int PAGE_SIZE_10 = 10;

    public ApplicationDaoImpl(){
        setClazz(Application.class );
    }

    public List<Application> getAppsByUserId(int userId, Integer number, Integer count) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
        Root<Application> applicationRoot = criteria.from(Application.class);
        criteria.select(applicationRoot).where(builder.equal(applicationRoot.get("userId"), userId));
        TypedQuery<Application> query = entityManager.createQuery(criteria);
        query.setFirstResult(number);
        query.setMaxResults(count == null ? PAGE_SIZE_10 : count);
        if(query.getResultList().isEmpty())
            return null;
        return query.getResultList();
    }


    public Application getUsersAppByAppName(int userId, String appName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
        Root<Application> applicationRoot = criteria.from(Application.class);
        criteria.select(applicationRoot).where(
                builder.equal(applicationRoot.get("name"), appName),
                builder.equal(applicationRoot.get("userId"), userId)
                );
        TypedQuery<Application> query = entityManager.createQuery(criteria);
        if(query.getResultList().isEmpty())
            return null;
        return query.getResultList().get(0);
    }


    public Application getUsersAppByAppId(int userId, String appId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
        Root<Application> applicationRoot = criteria.from(Application.class);
        criteria.select(applicationRoot);
        criteria.where(
                builder.equal(applicationRoot.get("userId"), userId),
                builder.equal(applicationRoot.get("appId"), appId)
        );
        TypedQuery<Application> query = entityManager.createQuery(criteria);
        if(query.getResultList().isEmpty())
            return null;
        return query.getResultList().get(0);
    }
}
