import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int getStrbyName(String playerName) {  // Метод получения значения силы по имени игрока
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player.getStrength();
            }
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        if (getStrbyName(playerName1) == -1) {
            throw new NotRegisteredException("Игрок не зарегистрирован: " + playerName1);
        } else if (getStrbyName(playerName2) == -1) {
            throw new NotRegisteredException("Игрок не зарегистрирован: " + playerName2);
        }

        if (getStrbyName(playerName1) > getStrbyName(playerName2)) {
            return 1;
        } else if (getStrbyName(playerName1) < getStrbyName(playerName2)) {
            return 2;
        } else
            return 0;
    }

}
