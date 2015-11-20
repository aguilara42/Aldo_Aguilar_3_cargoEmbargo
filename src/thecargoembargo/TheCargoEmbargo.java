
package thecargoembargo;
import java.util.Random;
import java.util.Scanner;

public class TheCargoEmbargo {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static String name;
    static boolean whistle = false;
    static boolean can = false;
    static boolean battleChoice = false;
    static int hoboHealth = 30;
    static int healthBar = 35;
    
     
    public static void main(String[] args) {
        startUp();
       
    }
    
    static void startUp(){
        System.out.println("");
        System.out.println("Welcome to the Cargo Embargo.");
        System.out.println("What is your name?");
        name = sc.nextLine();
        System.out.println("Would you like to 1.Play the game 2. Leave");
        int menu = sc.nextInt();
        
        if (menu == 1){
            System.out.println("The game will now start");
            System.out.println("");
            chapter1Act1();
        }
        if (menu == 2){
            goodBye();
        }
    }
    
    static void chapter1Act1(){
        System.out.println("You wake up on a Sunday morning feeling pretty good. ");
        System.out.println("What do you wear?");
        
        boolean choice1 = false;
            while(choice1 != true){
            System.out.println("Cargo shorts");
            System.out.println("Chubbies");
            String shorts = sc.nextLine();
            if(shorts.contains("Ca") ||shorts.contains("ca") ){
                choice1 = true;
                System.out.println("You put on a pair of ugly cargo shorts.");
                System.out.println("In the pockets you find nothing.");
                chapter1Act2();
         }
        
        
            if (shorts.contains("Ch") || shorts.contains("ch")){
                whistle = true;
                choice1 = true;
                System.out.println("Nice choice you make your way out of the door");
                System.out.println("In your pockets you find some kind of whistle. (It is added to your inventory)");
                chapter1Act2();
            }
        }
    }
    
    static void chapter1Act2(){
        System.out.println("Steping out of the door you see a hobo");
        System.out.println("He seems to be in distress, do you help him?");
       
        boolean choice2  = false;
        
        while(choice2 != true){
            System.out.println("Yes, of course");
            System.out.println("No, why would I ");
            String act2 = sc.nextLine();
            if (act2.equalsIgnoreCase("yes")){
                can = true;
                choice2 = true;
                System.out.println("You begin to walk towards the homeless man.");
                System.out.println("You pick up a tin can");
                chapter1Act3();
         }
        
            if (act2.equalsIgnoreCase("no")){
                choice2 = true;
                System.out.println("You walk towards your car.");
                chapter1Act3();
        }
    }
    }
    static void chapter1Act3(){
        System.out.println("The homeless man ask for some spare change");
        System.out.println("Do you have anything to give him?");
        System.out.println("You can press I to view your inventory");
        boolean inventory = false;
        
        
        while(inventory != true){
            String act3a = sc.nextLine();
            
            if (act3a.equalsIgnoreCase("i")){
                System.out.println("-------------");
                if (can){
                    System.out.println("Can");
                }
                
                if(whistle){
                    System.out.println("Whistle");
                }
                System.out.println("-------------");
                
            }
            
            if(act3a.equalsIgnoreCase("can")){
                System.out.println("The hobo takes the can and challenges you to a battle");
                System.out.println("The hobo will do more damage since he has a can weapon");
                battle(4);
            }
            
            if(act3a.equalsIgnoreCase("wh")){
                System.out.println("The hobo blows the whistle and the cops come to pick you up");
                lose();
                
            }
            
            if(act3a.equalsIgnoreCase("yes")){
                System.out.println("What do you have?");
            }
            
            if(act3a.equalsIgnoreCase("no")){
                System.out.println("The hobo puts his fist up and is ready to fight you");
                battle(2);
            }
        }
        
    }
    
    static void battle(int x){
        
        while(hoboHealth > 0 & healthBar > 0){
            boolean userTurn = false;
            if(userTurn != true){
                int hoboAttack = x + rand.nextInt(2);
                
                System.out.println("----------------------------------------");
                System.out.println("The hobo attacks and deals " + hoboAttack);
                healthBar = healthBar - hoboAttack;
                System.out.println("You have " + healthBar + " health left.");
                System.out.println("----------------------------------------");
                sc.nextLine();
                
                userTurn = true;
            }
            if(userTurn == true){
                battleChoice = false;
                while(battleChoice != true){
                    System.out.println("-------------------------------------");
                    System.out.println("Do you 1.attack or 2.Check inventory?");
                    int turn = sc.nextInt();
                
                    if(turn == 1){
                        int attackPower =rand.nextInt(6);
                        System.out.println("You attack and deal " + attackPower);
                        hoboHealth = hoboHealth - attackPower;
                        System.out.println("The hobo has " + hoboHealth + " left");
                        battleChoice = true;
                        userTurn = false;
                        
                    }
                    if(turn == 2){
                        System.out.println("----------");
                        if(whistle){
                            System.out.println("you have a whistle");
                        }
                        System.out.println("----------");
                        
                    }
                    System.out.println("-------------------------------------");
                }
                
            }
            
        }
        if (healthBar <= 0){
            lose();
        }
        
        else if(hoboHealth <= 0){
            win();
        }
    }
    
    
    static void lose(){
        System.out.println("==========");
        System.out.println(" You Lost ");
        System.out.println("==========");
        System.out.println("Sorry for your lose you will now return to the menu");
        startUp();

    }
    
    static void win(){
        System.out.println("You have won and saved the world from cargo short hobos.");
        goodBye();
    }
    
    static void goodBye(){
        System.out.println("Thanks " + name +" for playing the cargo embargo." );
    }
}
