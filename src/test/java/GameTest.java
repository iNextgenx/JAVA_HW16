import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player igrok1 = new Player(10, "Vasya", 95);
    Player igrok2 = new Player(15, "Kolya", 60);
    Player igrok3 = new Player(17, "Alena", 100);
    Player igrok4 = new Player(22, "Egor", 10);
    Player igrok5 = new Player(33, "Igor", 60);


    @Test
    public void shouldTestGetStrByName() {

        Game game = new Game();

        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        int expected = 10;
        int actual = game.getStrbyName("Egor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundWhen2more1() {  // 2 игрок сильнее

        Game game = new Game();
        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        int expected = 2;
        int actual = game.round("Vasya", "Alena");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundWhen1morethan2() {  // 1 игрок сильнее

        Game game = new Game();
        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        int expected = 1;
        int actual = game.round("Vasya", "Egor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundWhenEq() {  // Равны по силе

        Game game = new Game();
        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        int expected = 0;
        int actual = game.round("Kolya", "Igor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundExceptionWhen1stNonRegistered() {  // Первый игрок не зарегистрирован

        Game game = new Game();
        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna", "Alena");
        });
    }

    @Test
    public void shouldTestRoundExceptionWhen2stNonRegistered() {  // Второй игрок не зарегистрирован

        Game game = new Game();
        game.register(igrok1);
        game.register(igrok2);
        game.register(igrok3);
        game.register(igrok4);
        game.register(igrok5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Igor", "Vlad");
        });
    }


}
