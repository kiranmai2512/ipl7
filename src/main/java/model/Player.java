package model;


public class Player {
    private String name;
    private String team;
    private String role;
    private int runs;

    public Player(String name, String team, String role, int runs) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.runs = runs;
    }

    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getRole() { return role; }
    public int getRuns() { return runs; }

    @Override
    public String toString() {
        return "Name: " + name + ", Team: " + team + ", Role: " + role + ", Runs: " + runs;
    }
}
