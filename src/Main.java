import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int crapsRoll2 = 0;
        int thePoint = 0;
        String playAgain = "";
        boolean gameDone = false;
        boolean pointDone = false;
        boolean gameAgain = false;

       do
       {
           die1 = rnd.nextInt(6)+1;
           die2 = rnd.nextInt(6)+1;
           crapsRoll = die1 + die2;

           if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
           {
               System.out.println("You crapped out! You lose! You rolled " + die1 + " and " + die2 + " which equaled " + crapsRoll + ".");
               gameDone = true;
           }
           else if (crapsRoll == 7 || crapsRoll == 11)
           {
               System.out.println("You got a natural! You win! You rolled " + die1 + " and " + die2 + " which equaled " + crapsRoll + ".");
               gameDone = true;
           }
           else
           {
               thePoint = crapsRoll;
               System.out.println("You rolled a " + thePoint + "! Your rolls were " + die1 + " and " + die2 + ".");
               do
               {
                   die1 = rnd.nextInt(6)+1;
                   die2 = rnd.nextInt(6)+1;
                   crapsRoll2 = die1 + die2;

                   if (crapsRoll2 == 7)
                   {
                       System.out.println("You rolled " + crapsRoll2 + "! You lose! Your rolls were " + die1 + " and " + die2 + ".");
                       pointDone = true;
                       gameDone = true;
                   }
                   else if (crapsRoll2 == thePoint)
                   {
                       System.out.println("You rolled " + thePoint + "! You win! Your rolls were " + die1 + " and " + die2 + ".");
                       pointDone = true;
                       gameDone = true;
                   }
                   else
                   {
                       System.out.println("You rolled " + crapsRoll2 + "! Rolling again.");
                   }
               }while(!pointDone);
           }

       do
       {
       System.out.print("Would you like to play again [Y/N]?: ");
       playAgain = in.nextLine();
       if (playAgain.equalsIgnoreCase("Y"))
            {
                gameDone = false;
                gameAgain = true;
            }
            else if (playAgain.equalsIgnoreCase("N"))
            {
                gameAgain = true;
            }
            else
            {
                System.out.println("You entered " + playAgain + " which is an invalid input. Try again.");
                gameAgain = false;
            }
        }while (!gameAgain);

       }while(!gameDone);




    }
}