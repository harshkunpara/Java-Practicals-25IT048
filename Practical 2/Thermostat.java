public class Thermostat{
private String location;
private int temperature;
private static final int MIN=16;
private static final int MAX=30;
private static int activeCount=0;
Thermostat(String location,int startTemp){
this.location=location;
if(startTemp<=MAX&&startTemp>=MIN){
this.temperature=startTemp;
}
else{
temperature=22;
}
activeCount++;
}
Thermostat(String location){
    this(location,22);
}
public void  raise(){
    if(temperature<MAX){
    temperature ++;
    }
    else{
        System.out.println("Already at maximum (30)");
    }
}
public void  lower(){
    if(temperature>MIN){
    temperature --;
    }
    else{
        System.out.println("Already at minimum (16)");
    }
}
public int getTemperature(){
    return temperature;
}
public static int getActiveCount(){
    return activeCount;
}
public static void main(String[] args) {
    Thermostat T1=new Thermostat("Bedroom",22);
Thermostat T2=new Thermostat("Living Room");
System.out.println("Initial Temperature: "+T1.getTemperature());
System.out.println("\n Raising Temperature:");
for(int i=0;i<10;i++){
    T1.raise();
System.out.println("Temprature= "+T1.getTemperature());
}
System.out.println("\nLowering Temperature:");
for(int i=0;i<20;i++){
    T1.lower();
System.out.println("Temprature= "+T1.getTemperature());
}
System.out.println("\n Total  Active Thermostats:"+T1.getActiveCount());
}
}