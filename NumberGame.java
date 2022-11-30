import java.util.*;

class Game{
    public void game(){
        int randomNumber, guessNo, guessCount;
        guessCount=1;
        randomNumber=(int)(Math.random()*100);
        Scanner sc= new Scanner(System.in);
        System.out.println("==============================Guess the Number Game======================================");
        System.out.println("Enter any number between 1 to 100. Remember that you have only 5 guesses");
        guessNo= sc.nextInt();

        while(guessCount<6){
            if(guessNo==randomNumber){
                System.out.println("Congratulations!!!!!! You have guessed the correct number!!! The random number was "+randomNumber);
                break;
            }
            if(guessNo<randomNumber){
                System.out.println("The random number is greater than your guessed number ");
            }
            else if(guessNo>randomNumber){
                System.out.println("The random number is less than the guessed number");

            }

            System.out.print("Enter your next guess: ");
            guessNo=sc.nextInt();
            guessCount++;

        }
        if(guessCount>5){
            System.out.println("Thats all you have guessed 5 times!!!. Try again in next game!!");
            System.out.println("By the way the random number chosen was: "+randomNumber);
        }


    }
}

class NumberGame{
    public static void main(String args[]){
        Game g= new Game();
        g.game();
    }
}