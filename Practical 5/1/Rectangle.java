class Rectangle extends Shape{
    double lenght,width;
    Rectangle(double l,double w){
        lenght=l;
        width=w;
    }
    double area(){
        return lenght*width;
    }
} 
