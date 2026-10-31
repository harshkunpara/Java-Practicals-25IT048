public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue=0;
    public ParkingLot(int twoCap,int fourCap){
    this.fourCap=fourCap;
    this.twoCap=twoCap;
    } 
    public void park(String type){
    if(type.equalsIgnoreCase("two")){
        if(twoWheelers<twoCap){
    twoWheelers++;
    revenue+=20;
     System.out.println("Two Wheeler Parked");
    }
    else{
       System.out.println("Full");
    }

    }
    else if(type.equalsIgnoreCase("four")){
    if(fourWheelers<fourCap){
        fourWheelers++;
        revenue+=40;
 System.out.println("Four Wheeler Parked");
    }
    else{
       System.out.println("Full");
    }
    }

}
public void leave(String type){
if(type.equalsIgnoreCase("two")){
    if(twoWheelers>0){
     twoWheelers--;
    }
}
else if(type.equalsIgnoreCase("four")){
    if(fourWheelers>0){
     fourWheelers--;
    }
}
}
public int getTwoWheelrs(){
    return twoWheelers;
}
public int getFourWheelars(){
    return fourWheelers;
}
public static long getrevenue(){
    return revenue;
}
public static void main(String[] args) {
    ParkingLot P=new ParkingLot(3, 2);
    P.park("two");
    P.park("two");
    P.park("two");
    P.park("two");

    P.park("four");
    P.park("four");
    P.park("four");

    P.leave("two");
    P.leave("four");
    System.out.println("\nFinal Occupancy");
    System.out.println("Two Wheelers : "+P.getTwoWheelrs());
     System.out.println("Four Wheelers : "+P.getFourWheelars());
     System.out.println("Revenue :" + ParkingLot.getrevenue());
}
}
//25IT048