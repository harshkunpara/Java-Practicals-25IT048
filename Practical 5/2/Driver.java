public class Driver {
    public static void main(String[] args) {
        Employee Employees[]={
        new FullTime("Harsh", 101, 50000),
        new PartTime("Riya", 102, 100, 200),
        new Intern("Amit", 103, 10000)
};
double total=0;
for(Employee e:Employees){
double salary=e.monthlySalary();
System.out.println(e.name+":"+salary);
total+=salary;
 if (e instanceof Intern) {
        System.out.println("Note: This employee is an Intern.");}
}
System.out.println("Total Salary: "+total);
}
}
