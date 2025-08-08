package controller;



import model.Player;
import view.PlayerView;
import java.util.*;

public class PlayerController {
    private List<Player> playerList = new ArrayList<>();
    private PlayerView view = new PlayerView();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- IPL Player Management ---");
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Search by Team");
            System.out.println("4. Filter by Role");
            System.out.println("5. Sort by Runs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
            case 1:
                addPlayer();
                break;
            case 2:
                view.showAllPlayers(playerList);
                break;
            case 3:
                searchByTeam();
                break;
            case 4:
                filterByRole();
                break;
            case 5:
                sortByRuns();
                break;
            case 6:
                view.showMessage("Thank you for using IPL Player Management System.");
                return;
            default:
                view.showMessage("Invalid choice. Please try again.");
                break;
        }


        }
    }

    private void addPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        System.out.print("Enter team: ");
        String team = scanner.nextLine();
        System.out.print("Enter role (Batsman/Bowler/All-Rounder): ");
        String role = scanner.nextLine();
        System.out.print("Enter total runs: ");
        int runs = scanner.nextInt();
        scanner.nextLine();

        playerList.add(new Player(name, team, role, runs));
        view.showMessage("Player added successfully!");
    }

    private void searchByTeam() {
        System.out.print("Enter team name to search: ");
        String team = scanner.nextLine();
        List<Player> filtered = new ArrayList<>();

        for (Player p : playerList) {
            if (p.getTeam().equalsIgnoreCase(team)) {
                filtered.add(p);
            }
        }
        view.showAllPlayers(filtered);
    }

    private void filterByRole() {
        System.out.print("Enter role to filter (Batsman/Bowler/All-Rounder): ");
        String role = scanner.nextLine();
        List<Player> filtered = new ArrayList<>();

        for (Player p : playerList) {
            if (p.getRole().equalsIgnoreCase(role)) {
                filtered.add(p);
            }
        }
        view.showAllPlayers(filtered);
    }

    private void sortByRuns() {
        playerList.sort(Comparator.comparingInt(Player::getRuns).reversed());
        view.showAllPlayers(playerList);
    }
}
