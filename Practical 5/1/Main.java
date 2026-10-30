public class Main {
    public static void main(String[] args) {
    Shape shapes[]={
            new Circle(5),
            new Rectangle(4,6),
            new Triangle(3,8)
    };
        double total = 0;
        double largest = 0;

        for(Shape s : shapes) {

            double a = s.area(); 

            System.out.println(a);

            total += a;

            if(a > largest)
                largest = a;
        }

System.out.println("Total: " + total);
System.out.println("Largest: " + largest);
    }
}
