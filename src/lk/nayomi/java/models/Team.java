package lk.nayomi.java.models;


import java.util.Scanner;

public class Team {
    private static Scanner sc;


    private static int[][] players = new int[6][2];

    private String name;
    private int totalRuns;
    private int totalBalls;

    public static int[][] getPlayers() {
        return players;
    }

    public static void setPlayers(int[][] players) {
        Team.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }
}
