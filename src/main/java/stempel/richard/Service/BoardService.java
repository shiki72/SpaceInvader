package stempel.richard.Service;

import org.pmw.tinylog.Logger;
import stempel.richard.Model.Database.DAO.BoardDAO;
import stempel.richard.Model.Database.Entity.Board;

import java.util.List;

public class BoardService {

    private static BoardDAO boardDAO;

    /**This is the contstructor which makes a new {@code BoardDAO}.*/
    public BoardService() {
        boardDAO = new BoardDAO();
    }

    /**This method will push a {@code Board} to the database.
     *
     * @param entity is the chosen {@code Board}.*/
    public void persist(Board entity) {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.persist(entity);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board persisited.");
    }

    /**This method will update a {@code Board} in the database.
     *
     * @param entity is the chosen {@code Board}.*/
    public void update(Board entity) {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.update(entity);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board updated.");
    }

    /**This method will find a {@code Board} in the database by id.
     *
     * @param id is the searched id.
     *
     * @return the found {@code Board}.*/
    public Board findById(Integer id) {
        boardDAO.openCurrentSession();
        Board board = boardDAO.findById(id);
        boardDAO.closeCurrentSession();
        Logger.info("Board with " + board.getId() + " id found.");
        return board;
    }

    /**This method will delete a {@code Board} from the database by id.
     *
     * @param id is the searched id.*/
    public void delete(Integer id) {
        boardDAO.openCurrentSessionwithTransaction();
        Board board = boardDAO.findById(id);
        boardDAO.delete(board);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board with " + board.getId() + " id deleted.");
    }

    /**This method will retrieve all {@code Board}s in the database.
     *
     * @return the list of the {@code Board}.*/
    public List<Board> findAll() {
        boardDAO.openCurrentSession();
        List<Board> boards = boardDAO.findAll();
        boardDAO.closeCurrentSession();
        Logger.info("Found every Board.");
        return boards;
    }

    /**This method will delete all {@code Board}s from the database.*/
    public void deleteAll() {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.deleteAll();
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("All board deleted.");
    }

    /**@return the {@code BoardDAO}.*/
    public BoardDAO boardDAO() {
        return boardDAO;
    }
}
