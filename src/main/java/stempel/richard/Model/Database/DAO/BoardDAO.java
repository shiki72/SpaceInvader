package stempel.richard.Model.Database.DAO;

import stempel.richard.Model.Database.Entity.Board;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class BoardDAO implements BoardDAOInterface<Board, Integer> {

    private Session currentSession;
    private Transaction currentTransaction;

    public BoardDAO() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Board.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Board entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Board entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Board findById(Integer id) {
        Board board = (Board) getCurrentSession().get(Board.class, id);
        return board;
    }

    @Override
    public void delete(Board entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Board> findAll() {
        List<Board> boards = (List<Board>) getCurrentSession().createQuery("from Board").list();
        return boards;
    }

    @Override
    public void deleteAll() {
        List<Board> entityList = findAll();
        for (Board entity : entityList) {
            delete(entity);
        }
    }
}
