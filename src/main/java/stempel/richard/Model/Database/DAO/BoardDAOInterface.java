package stempel.richard.Model.Database.DAO;

import java.io.Serializable;
import java.util.List;

public interface BoardDAOInterface<T, Id extends Serializable> {

    /**@param entity will be pushed to the database by this method.*/
    void persist(T entity);
    /**@param entity will be updated in the database by this method.*/
    void update(T entity);
    /**@param id will be searched in the database.
     *
     * @return if this method found an element then this will be returned.*/
    T findById(Id id);
    /**@param entity will be deleted from the database by this method.*/
    void delete(T entity);
    /**Retrieves all elements from the databases.
     *
     * @return the retrieved elements in a {@code List}.*/
    List<T> findAll();
    //public List<Player> findByScoreTop10();
    /**Deletes all elements from the database.*/
    void deleteAll();

}