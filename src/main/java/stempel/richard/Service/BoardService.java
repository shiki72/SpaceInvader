package stempel.richard.Service;

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
    }

    public void update(Board entity) {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.update(entity);
        boardDAO.closeCurrentSessionwithTransaction();
    }

    public Board findById(Integer id) {
        boardDAO.openCurrentSession();
        Board board = boardDAO.findById(id);
        boardDAO.closeCurrentSession();
        return board;
    }

    public void delete(Integer id) {
        boardDAO.openCurrentSessionwithTransaction();
        Board board = boardDAO.findById(id);
        boardDAO.delete(board);
        boardDAO.closeCurrentSessionwithTransaction();
    }

    public List<Board> findAll() {
        boardDAO.openCurrentSession();
        List<Board> boards = boardDAO.findAll();
        boardDAO.closeCurrentSession();
        return boards;
    }

    public void deleteAll() {
        boardDAO.openCurrentSessionwithTransaction();
        boardDAO.deleteAll();
        boardDAO.closeCurrentSessionwithTransaction();
    }

    public BoardDAO playerDao() {
        return boardDAO;
    }
}
