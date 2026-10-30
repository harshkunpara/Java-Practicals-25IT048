public class Driver {
    public static void main(String[] args) {
        Point[] points={
            new Point(2,3),
             new Point(1,3),
             new Point(6,2),
             new Point(6,5),
             new Point(2,3),
             new Point(4,5),
             new Point(2,5),
             new Point(1,3)
    };
    int count=0;
    for(int i=0;i<points.length;i++){
     boolean found=false;
     for(int j=0;j<i;j++){
     if(points[i].equals(points[j])){
  found=true;
  break;
     }
     }
     if(!found){
     count++;
     }
    }
    System.out.println("Points:");
    for(Point p:points){
 System.out.println(p);

    }
     System.out.println("Distinct:"+count);
}
}