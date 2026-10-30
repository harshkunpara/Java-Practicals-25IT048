class Box<T> {
    private T value;
    public void set(T value) {
        this.value = value;}
    public T get() {
        return value;}}
class Pair<A, B> {
    private A first;
    private B second;
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;}
 public A getFirst(){
        return first;}
    public B getSecond() {
        return second;}}
public class GenericDemo {
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return array[0];}
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(100);
        System.out.println("Box value: " + box1.get());
        Box<String> box2 = new Box<>();
        box2.set("Hello Java");
        System.out.println("Box value: " + box2.get());
        Pair<String, Integer> pair =
                new Pair<>("Harsh", 20);
        System.out.println("Pair: "
                + pair.getFirst() + ", " + pair.getSecond());
        Integer[] numbers = {10, 20, 30};
        String[] names = {"Harsh", "Rahul"};
        System.out.println(
                "First number: " + firstElement(numbers));
        System.out.println(
                "First name: " + firstElement(names));
}
}
