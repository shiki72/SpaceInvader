package stempel.richard.Service;

import org.pmw.tinylog.Logger;
import stempel.richard.Model.Database.DAO.BoardDAO;
import stempel.richard.Model.Database.Entity.Board;

import java.util.List;

public class BoardService {

    private static BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }

    public void persist(Board entity) {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.persist(entity);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board persisited.");
    }

    public void update(Board entity) {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.update(entity);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board updated.");
    }

    public Board findById(Integer id) {
        boardDAO.openCurrentSession();
        Board board = boardDAO.findById(id);
        boardDAO.closeCurrentSession();
        Logger.info("Board with " + board.getId() + " id found.");
        return board;
    }

    public void delete(Integer id) {
        boardDAO.openCurrentSessionwithTransaction();
        Board board = boardDAO.findById(id);
        boardDAO.delete(board);
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("Board with " + board.getId() + " id deleted.");
    }

    public List<Board> findAll() {
        boardDAO.openCurrentSession();
        List<Board> boards = boardDAO.findAll();
        boardDAO.closeCurrentSession();
        Logger.info("Found every Board.");
        return boards;
    }

    public void deleteAll() {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.deleteAll();
        boardDAO.closeCurrentSessionwithTransaction();
        Logger.info("All board deleted.");
    }

    public BoardDAO boardDAO() {
        return boardDAO;
    }
}
