import java.util.Scanner;
import java.util.Random;
enum Move{
ROCK,
PAPER,
SCISSORS,
LIZARD,
SPOCK;
}
public class RPSLS{
    static int winner(Move a,Move b){
    if(a==b){
    return 0;
    }
    boolean awins=switch(a){
    case ROCK -> b == Move.SCISSORS || b == Move.LIZARD;
    case PAPER -> b == Move. ROCK || b == Move.SPOCK;
    case SCISSORS -> b == Move.PAPER || b == Move.LIZARD;
    case LIZARD -> b == Move.PAPER || b == Move.SPOCK;
    case SPOCK -> b == Move. ROCK || b == Move.SCISSORS;
    };
    if(awins){
        return 1;
    }
    else{
        return -1;
    }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        Move[] moves = Move.values();

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRound " + i);
            Move player=null;

           while(player==null){
           System.out.print("Enter Move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
           String input=sc.next();
            try{
           player=Move.valueOf(input.toUpperCase());
    }
        catch(IllegalArgumentException e){
        System.out.println("Invalid Move. Try Again.");
   }
}           Move computer = moves[random.nextInt(moves.length)];

            System.out.println("Player Move: " + player);
            System.out.println("Computer Move: " + computer);

            int result = winner(player, computer);

            if (result==1) {
                System.out.println("You Win This Round");
                playerScore++;
            } else if (result==-1) {
                System.out.println("Computer Wins This Round");
                computerScore++;} 
            else {
                System.out.println("Round Tie");}
        }
        System.out.println("\nFinal Score");

        System.out.println("Player: "+playerScore);
        System.out.println("Computer: "+computerScore);

        if (playerScore > computerScore) {
            System.out.println("You Win " + playerScore + "-" + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("Computer Wins "+computerScore+"-"+playerScore);
        } else {
            System.out.println("Overall Tie "+playerScore+"-"+computerScore);
        }
        sc.close();
    }
}
