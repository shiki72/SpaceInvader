package stempel.richard.Model.Database.DAO;

import java.io.Serializable;
import java.util.List;

public interface BoardDAOInterface<T, Id extends Serializable> {

    void persist(T entity);
    void update(T entity);
    T findById(Id id);
    void delete(T entity);
    List<T> findAll();
    //public List<Player> findByScoreTop10();
    void deleteAll();

}