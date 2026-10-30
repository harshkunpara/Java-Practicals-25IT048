import java.util.Scanner;

public class Driverr {
    public static void main(String[] args) {
        String[] logs={
                "10:05 alice Hello there",
                "10:10 bob Good Morning",
                "WrongLine",
                "10:20 john Hello Harsh",
                "10:30 david Bye"
        };
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Keyword:");
        String Keyword=sc.nextLine();
        String result=ChatFilter.filter(logs, Keyword);
        System.out.println(result);
        sc.close();
    }
}
