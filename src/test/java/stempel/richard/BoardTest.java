package stempel.richard;

import org.junit.Before;
import org.junit.Test;
import stempel.richard.Model.Database.Entity.Board;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception{
        board = new Board();
        board.setId(1);
        board.setName("Kacsa");
        board.setScore(2);
    }

    @Test
    public void getId() {
        assertEquals(1, board.getId());
    }

    @Test
    public void getName() {
        assertEquals("Kacsa", board.getName());
    }

    @Test
    public void getScore() {
        assertEquals(2, board.getScore());
    }

    @Test
    public void toStringTest() {
        assertEquals("Player: 1, Kacsa, 2",board.toString());
    }
}
