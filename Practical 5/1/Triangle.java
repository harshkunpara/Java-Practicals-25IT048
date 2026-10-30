class Triangle extends Shape{
    double base,hight;
    Triangle(double B, double H) {
            base = B;
            hight = H;
    }
    double area() {
        return base * hight;
    }
}
  