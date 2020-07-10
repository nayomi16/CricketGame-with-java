package lk.nayomi.java.main;

import lk.nayomi.java.models.Game;
import lk.nayomi.java.models.Team;

import java.util.Scanner;

public class Start {
    private static Scanner sc;
    public static void main(String[] args) {
        System.out.print("Sup, Welcome to the game of Cricket!!\nplease enter names of two teams\n\n");
        sc=new Scanner(System.in);
        String team1name=sc.next();
        sc=new Scanner(System.in);
        String team2name=sc.next();

        Team team1=new Team();
        team1.setName(team1name);
        System.out.println(team1.getName());
        Team team2=new Team();
        team2.setName(team2name);

        int toss = Game.toss();
        if(toss==0){
            System.out.print(team1.getName() + " won the toss\n\n ");
            Game.playGame(team1,team2);

        }else {
            System.out.print(team2.getName() + " won the toss\n\n");
            Game.playGame(team2,team1);
        }
        Game.TotalScore(team1,team2);

    }
}
