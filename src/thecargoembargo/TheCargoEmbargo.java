
package thecargoembargo;
import java.util.Scanner;

public class TheCargoEmbargo {
    static Scanner sc = new Scanner(System.in);
    static int lives = 3; 
    static String name;
     
    public static void main(String[] args) {
       while(lives == 0){
           
       }
        startUp();
       
    }
    
    static void startUp(){
        System.out.println("");
        System.out.println("Welcome to the Cargo Embargo.");
        System.out.println("What is your name?");
        name = sc.nextLine();
        System.out.println("The game will now start " + name +".");
        System.out.println("");
        chapter1Act1();
    }
    
    static void chapter1Act1(){
        System.out.println("You wake up on a Sunday morning feeling pretty good. ");
        System.out.println("What do you wear?");
        System.out.println("Cargo shorts");
        System.out.println("Chubbies");
        String shorts = sc.nextLine();
        if(shorts.contains("Ca") ||shorts.contains("ca") ){
            lose();
        }
        
        if (shorts.contains("Ch") || shorts.contains("ch")){
            System.out.println("Good");
        }
    }
    
    static void lose(){
        System.out.println("==========");
        System.out.println(" You Lost ");
        System.out.println("==========");
        System.out.println("you have " + " tries left");
        System.out.println("Would you like to play agian ");
        System.out.println("1.yes");
        System.out.println("2.No");
    }
}
