import java.util.Scanner;

enum Coin{
        ONE,
        TWO,
        FIVE,
        TEN
    }
public class VendingMachine{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
  int Price=15;
  int Total=0;
  while(Total<Price){
  System.out.print("Enter A Coin(TEN,FIONEVE,TWO,ONE):");
 Coin coin=Coin.valueOf(sc.next());
int value= switch(coin){
case ONE->1;
case TWO->2;
case FIVE->5;
case TEN->10;
};
Total=Total+value;
System.out.println("Total Is:"+Total);
}
int chnage=Total-Price;
System.out.println("Paid...Change:"+chnage);
sc.close();
}
}