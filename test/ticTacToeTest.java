import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ticTacToeTest {

    @Test
    void testInPole() {
        ticTacToe main = new ticTacToe(3);
        char[][] result1 = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        main.inPole();
        assertArrayEquals(result1, main.pole);

        main = new ticTacToe(2);
        char[][] result2 = {
                {' ',' '},
                {' ',' '}
        };
        main.inPole();
        assertArrayEquals(result2, main.pole);

        main = new ticTacToe(4);
        char[][] result3 = {
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '}
        };
        main.inPole();
        assertArrayEquals(result3, main.pole);
    }

    @Test
    void testPutK() {
        ticTacToe main = new ticTacToe(3);
        main.inPole();
        main.putK(1, 2);
        assertEquals('x', main.pole[1][2]);

        main = new ticTacToe(5);
        main.inPole();
        main.putK(4, 4);
        assertEquals('x', main.pole[4][4]);
    }

    @Test
    void testPutO() {
        ticTacToe main = new ticTacToe(4);
        main.inPole();
        main.putO(3, 3);
        assertEquals('o', main.pole[3][3]);

        main = new ticTacToe(2);
        main.inPole();
        main.putO(0, 1);
        assertEquals('o', main.pole[0][1]);
    }

    @Test
    void testClear() {
        ticTacToe main = new ticTacToe(5);
        main.inPole();
        main.putO(0, 0);
        main.clear(0, 0);
        assertEquals(' ', main.pole[0][0]);
    }

    @Test
    void testFindK() {
        ticTacToe main = new ticTacToe(3);
        main.inPole();
        main.putK(0, 0);
        main.putK(0, 1);
        main.putK(0, 2);
        LinkedList<String> result1 = new LinkedList<String>();
        result1.add("0;0");
        result1.add("0;1");
        result1.add("0;2");
        assertEquals(result1, main.findK());

        main = new ticTacToe(5);
        main.inPole();
        main.putK(4, 1);
        main.putK(3, 2);
        main.putK(2, 3);
        main.putK(1, 4);
        main.putK(4, 3);
        main.putK(4, 3);
        LinkedList<String> result2 = new LinkedList<String>();
        result2.add("4;1");
        result2.add("3;2");
        result2.add("2;3");
        result2.add("1;4");
        assertEquals(result2, main.findK());
    }

    @Test
    void testFindO() {
        ticTacToe main = new ticTacToe(4);
        main.inPole();
        main.putO(0, 0);
        main.putO(1, 1);
        main.putO(2, 2);
        main.putO(0, 2);
        main.putO(1, 2);
        main.putO(3, 2);
        LinkedList<String> result1 = new LinkedList<String>();
        result1.add("0;2");
        result1.add("1;2");
        result1.add("2;2");
        result1.add("3;2");
        assertEquals(result1, main.findO());

        main = new ticTacToe(2);
        main.inPole();
        main.putO(0, 1);
        main.putO(1, 1);
        main.putK(1, 0);
        main.putK(0, 0);
        LinkedList<String> result2 = new LinkedList<String>();
        result2.add("0;1");
        result2.add("1;1");
        assertEquals(result2, main.findO());
    }
}