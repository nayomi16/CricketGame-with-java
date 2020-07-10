package lk.nayomi.java.models;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner sc;
    public static int toss(){
        Random rnd=new Random();
        return (rnd.nextInt(2));
    }

    public static void playGame(Team team, Team team2){
        System.out.print("Enter 0 to bat or 1 to Bowl :-");

        int playerChoice=input();
        while (playerChoice!=0 && playerChoice!=1){
            System.out.print("Incorrect Entery!! Please Enter either 0 to bat and 1 to Bowl:-");
            playerChoice=input();
        }
        if(playerChoice==0){
            System.out.println(team.getName()+" choose to Bat.\n\nTeam "+team.getName()+" enter p to play");
            startPlay(team);
            System.out.println("\n\tSCOREBORD");
            System.out.println("========================================\n");
            showScore(team);
            System.out.println("Team "+team2.getName()+" turn to bat.");
            startPlay(team2);
            System.out.println("\n\tSCOREBORD");
            System.out.println("========================================\n");
            showScore(team2);
        }
        else{
            System.out.println(team.getName()+" choose to Bowl.\n\nTeam "+team2.getName()+" enter p to bat");
            startPlay(team2);
            System.out.println("\n\tSCORECARD");
            System.out.println("========================================\n");
            showScore(team2);
            System.out.println("Team "+team2.getName()+" turn to bowl.");
            startPlay(team);
            System.out.println("\n\tSCORECARD");
            System.out.println("========================================\n");
            showScore(team);
        }

    }

    public static int input(){
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void startPlay(Team team){
        int TotalCompBalls=0;

        for(int x=0;x<6;x++){

            int singleBalls=0;
            int singleTotal=0;

            int compScore;
            int playerScore;
            String play;
            loop:while (true){

                // compScore=score();
                singleBalls++;
                play=pressP();
                if(play.equals("p") || play.equals("P")){
                    playerScore=runs();
                    if(playerScore==7 || playerScore==5){
                        System.out.println("OUT!!- caught - player " + (x+1) + " managed to make "+singleTotal+" runs in " + singleBalls + " balls.");
                        break loop;
                    }
                    else if(playerScore>7 && playerScore<11){
                        System.out.println("OUT!! - bowled - player " + (x+1) + " managed to make "+singleTotal+" runs in " + singleBalls + " balls.");
                        break loop;
                    }else{singleTotal +=playerScore;
                        System.out.println(singleTotal);
                    }

                    if(singleBalls==15){
                        System.out.println("balls over");
                        break loop;
                    }

                }

                else{
                    System.out.println("Please press P");
                    singleBalls--;
                    continue loop;
                }


            }

            int[][] players=team.getPlayers();

            players[x][0] = singleTotal;
            players[x][1] = singleBalls;
            TotalCompBalls+= singleBalls;
            System.out.println(TotalCompBalls+"kkkk");
            if(TotalCompBalls>=15){
                x=7;
                System.out.println("balls over");

            }

        }
    }
    private static int runs() {
        Random rnd=new Random();
        return (rnd.nextInt(10));
    }

    private static String pressP() {
        sc=new Scanner(System.in);
        return sc.next();
    }


    public static void showScore(Team team){
        int[][] arr=team.getPlayers();
        int totalRuns = 0;
        int totalBalls = 0;

        System.out.println("Batsman\t\t\tScore\t\t\tBalls");

        for(int x=0;x<6;x++){
            System.out.print((x+1) + "\t\t\t\t" + arr[x][0] + "\t\t\t\t" + arr[x][1] + "\n");
            totalRuns += arr[x][0];
            totalBalls += arr[x][1];
        }

        team.setTotalRuns(totalRuns);
        team.setTotalBalls(totalBalls);
        System.out.println();
        System.out.println(team.getName()+" Total Runs : " + totalRuns );
        System.out.println(team.getName()+" Total Balls : " + totalBalls );

    }

    public static void TotalScore(Team team1, Team team2) {



        if(team1.getTotalRuns()>team2.getTotalRuns()){
            System.out.print(team1.getName() +" Congrats!! You won!");
        }
        else if(team2.getTotalRuns()>team1.getTotalRuns()){
            System.out.print(team2.getName() +" Congrats!! You won!");
        }
        else if(team2.getTotalRuns()==team1.getTotalRuns()) {
            System.out.println("Same runs");
        }

    }
}
