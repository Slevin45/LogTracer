package pro.smartum.app.dao;

import org.springframework.stereotype.Repository;
import pro.smartum.app.model.Identifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by eldar.s on 27.04.2016.
 */
@Repository
public abstract class BaseDao<T> {
    private Class< T > clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }


    public void persist(T entity) {
        entityManager.persist(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public T findById(Object id) {
        return (T) entityManager.find(clazz, id);
    }
}
