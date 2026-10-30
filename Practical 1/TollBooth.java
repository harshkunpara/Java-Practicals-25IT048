import java.util.Scanner;

record Vehicle(String Number,String type){

}
public class TollBooth {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int TotalToll=0;
    int Bikecount=0;
    int CarCount=0;
    int TruckCount=0;
    while(true){
    System.out.print("Enter Vehicle Number:");
    String Number=sc.next();
    if(Number.equalsIgnoreCase("Done")){
    break;
    }
    System.out.print("Enter Vehicle Type(BIKE,CAR,TRUCK):");
    String type=sc.next();
    Vehicle vehicle=new Vehicle(Number, type);
    int Toll=switch (vehicle.type()){
                case "BIKE" -> 20;
                case "CAR" -> 50;
                case "TRUCK" -> 150;
                default -> 0;
    };
    TotalToll=TotalToll+Toll;
    switch(vehicle.type()){
      case "BIKE"->Bikecount++;
      case "CAR"->CarCount++;
      case "TRUCK"->TruckCount++;
    }

}
     String mostFrequent;
     if(Bikecount>CarCount&&Bikecount>TruckCount){
        mostFrequent="BIKE";
     }
     else if(Bikecount<CarCount&&CarCount>TruckCount){
        mostFrequent="CAR";
     }
     else{
        mostFrequent="TRUCK";
     }
     System.out.println("Total Toll Is:"+TotalToll);
     System.out.println("Most Frequent:"+mostFrequent);
     sc.close();
}    
}

