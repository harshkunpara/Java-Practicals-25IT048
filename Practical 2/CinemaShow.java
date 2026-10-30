public class CinemaShow {
     private String title;
     private int seatsAvailable;
     private final int capacity;
     private static int totalBooked=0;
     CinemaShow(String title,int capacity){
       this.title=title;
       this.capacity=capacity;
       this.seatsAvailable=capacity;
     }
     CinemaShow(String title){
     this(title,100);
     }
     public boolean book(int n){
     if(n<=seatsAvailable){
    seatsAvailable-=n;
    totalBooked+=n;
    return true;
     }
     else{
        return false;
     }
     }
     public void cancle(int n){
     seatsAvailable=seatsAvailable+n;
     if(seatsAvailable>capacity){
     seatsAvailable=capacity;
     }
     }
     public int getSeatsAvailable(){
        return seatsAvailable;
     }
     public static  int getTotalBooked(){
        return totalBooked;
     }
public static void main(String[] args) {
    CinemaShow show1=new CinemaShow("Dhurandhar 3",200);
    CinemaShow show2=new CinemaShow("Animal 2");
    System.out.println(show1.book(20));
    System.out.println("Seat Left:"+show1.getSeatsAvailable());
    System.out.println(show1.book(90));
    System.out.println("Seat Left:"+show1.getSeatsAvailable());
    show1.cancle(10);
    System.out.println("Seat left:"+show1.getSeatsAvailable());
    System.out.println("Total Booked Seat:"+CinemaShow.getTotalBooked());
}
}
