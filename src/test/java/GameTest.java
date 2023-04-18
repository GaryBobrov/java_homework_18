import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 30);
        Player sasha = new Player(2, "Саша", 25);

        game.register(andrey);
        game.register(sasha);
        int actual = game.round("Андрей", "Саша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 30);
        Player sasha = new Player(2, "Саша", 45);

        game.register(sasha);
        game.register(andrey);
        int actual = game.round("Андрей", "Саша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 40);
        Player sasha = new Player(2, "Саша", 40);

        game.register(andrey);
        game.register(sasha);
        int actual = game.round("Саша", "Андрей");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 30);
        Player sasha = new Player(2, "Саша", 25);

        game.register(andrey);
        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Саша")
        );
    }

    @Test
    public void testWhenTheSecondPlayerDoesNotExist() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 30);
        Player sasha = new Player(2, "Саша", 25);

        game.register(andrey);
        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Андрей", "Коля")
        );
    }

    @Test
    public void testWhenNoPlayersExist() {
        Game game = new Game();
        Player andrey = new Player(1, "Андрей", 30);
        Player sasha = new Player(2, "Саша", 25);

        game.register(andrey);
        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Паша")
        );
    }
}