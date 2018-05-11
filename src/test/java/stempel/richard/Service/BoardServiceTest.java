package stempel.richard.Service;

import org.junit.Before;
import org.junit.Test;
import stempel.richard.Model.Database.Entity.Board;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class BoardServiceTest {
    private BoardService boardService;
    private Board board;

    @Before
    public void setUp() {
        board = new Board(1,"Very very long name", 12345);
        boardService = new BoardService();
        boardService.deleteAll();
    }

    @Test
    public void testPersist() {
        boardService.persist(board);
        List<Board> boards = boardService.findAll();
        assertEquals(board.getScore(),boards.get(0).getScore());
        assertEquals(board.getName(),boards.get(0).getName());
        boardService.delete(boards.get(0).getId());
    }

    @Test
    public void testDelete() {
        boardService.persist(board);
        List<Board> boards = boardService.findAll();
        assertEquals(1, boards.size());
        boardService.delete(boards.get(0).getId());
        boards = boardService.findAll();
        assertEquals(0, boards.size());
    }

    @Test
    public void testUpdate() {
        boardService.persist(board);
        List<Board> boards = boardService.findAll();
        boardService.update(new Board(boards.get(0).getId(),"Something other",boards.get(0).getScore()));
        List<Board> boards1 = boardService.findAll();
        assertEquals(boards.get(0).getId(),boards1.get(0).getId());
        assertNotSame(boards.get(0).getName(),boards1.get(0).getName());
        assertEquals(boards.get(0).getScore(),boards1.get(0).getScore());
        boardService.delete(boards.get(0).getId());
    }

    @Test
    public void testFindById() {
        boardService.persist(board);
        List<Board> boards = boardService.findAll();
        Board board1 = boardService.findById(boards.get(0).getId());
        assertEquals(board1.getId(),boards.get(0).getId());
        assertEquals(board1.getScore(),boards.get(0).getScore());
        assertEquals(board1.getName(),boards.get(0).getName());
        boardService.delete(boards.get(0).getId());
    }
}
