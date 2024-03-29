package com.praticals.projectAss;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class mainMenu {
    private static ArrayList<User> players = new ArrayList<>(); //initial empty user list

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // create all game instance in list
        Game[] allGames = new Game[2];
        allGames[0] = new stopClock();
        allGames[1] = new biGuess();
        String gamePanelSeparator = "*".repeat(30);
        String promoteCode = "promote";

        // read player list from file, parse it to player Arraylist
        try{
            FileInputStream fis = new FileInputStream("players.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            players = (ArrayList<User>) ois.readObject();
            ois.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("No historical player file found.");
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }

        while (true) {
            System.out.println("-----Welcome to GAMING BOARD-----");
            // In main menu, quit to show all user credit or start as new user
            boolean enterMain = enterBoard(scan);

            if (enterMain) {
                System.out.println(gamePanelSeparator);
                //ask for a new user name and create user
                System.out.println("Who is playing? ");
                String newName = scan.nextLine();

                System.out.println("Enter promote code to be a VIP player:");
                boolean promoted = scan.nextLine().equals(promoteCode);
                System.out.println((promoted ? "Valid " : "Invalid") + "promote code usage.");

                // if given correct promote code, create as VIP
                User playerNow;
                if (promoted){
                    playerNow = new vipUser(newName);
                } else {
                    playerNow = new User(newName);
                }
                players.add(playerNow);
                playerNow.greet();
                System.out.println(gamePanelSeparator);

                // print games list option and let user choose a game.
                while (true) {
                    // user use integer to choose game
                    int selectGameInt = -2; //initialized to 0 would end the loop
                    do {
                        displayGamesNames(allGames);
                        System.out.println("Enter game number to select game, 0 to quit, -1 to show current score:");
                        if (!scan.hasNextInt()) {
                            scan.next(); //skip non-integer inputs
                            System.out.println("Invalid option.");
                            continue;
                        }
                        selectGameInt = scan.nextInt();
                        if(selectGameInt == -1){
                            System.out.printf("Your score is %d. %n", playerNow.getScore());
                        }
                        scan.nextLine(); // skip one line to reset gaming board
                    } while (selectGameInt > allGames.length || selectGameInt < 0);


                    // if user choose to quit
                    if (selectGameInt == 0) {
                        break;
                    } else { // if user choose a game, let the game play
                        Game playingGame = allGames[selectGameInt - 1]; //one more for user integer
                        // prompt user to set a bet or to user default game points
                        playerNow.setBet(scan, playingGame);
                        scan.nextLine();
                        playingGame.describeGame();
                        playingGame.GameOn(playerNow, scan);
                    }
                }
            }else{
                System.out.println("****Ranking for all players****");
                scan.close();
                displayUsersRank(players);
                System.out.println("-----See you next time-----");

                // write player list to file
                try {
                    FileOutputStream fos = new FileOutputStream("players.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(players);
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    public static void displayGamesNames(Game[] arr){
        // function to print all existing game names
        System.out.println("----Game List ----");
        int index = 1;
        for(Game g:arr){
            System.out.println((index++)+": "+ g.getName());
        }
    }

    public static boolean enterBoard(Scanner fScan){
        // main board function for return boolean if user chosen to enter game panel
        while (true){
            System.out.println("Hit enter to start as new user, or 'q' to end game: ");
            String userChosen = fScan.nextLine();
            if (userChosen.isEmpty()){
                return true;
            }
            if (userChosen.equals("q")){
                System.out.println("-----Exiting GAMING BOARD-----");
                return false;
            }
        }
    }

    public static void displayUsersRank(ArrayList<User> userArr){
        userArr.sort(Collections.reverseOrder());
        int i = 1;
        for(User u:userArr){
            System.out.printf("%d . %s has %d scores. %n", i++, u.getName(), u.getScore());
        }
    }
}
