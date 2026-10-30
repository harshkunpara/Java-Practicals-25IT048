class Circle extends Shape{
    double radius;
    Circle(double r){
   radius=r;
    }
    double area(){
  return 3.14*radius*radius;
    }
}