package view;



import model.Player;
import java.util.List;

public class PlayerView {
    public void showAllPlayers(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
        } else {
            for (Player p : players) {
                System.out.println(p);
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
