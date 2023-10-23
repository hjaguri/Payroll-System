import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String n , int i_d){
        this.name=n;
        this.id=i_d;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name="+name+", id = "+ id + ", salary="+calculateSalary()+"]";
    }
}


class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name , int id , double monthlySalary){
        super(name , id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name , int id , int hoursWorked , double hourlyRate){
        super(name , id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate*hoursWorked;
    }
}


class payRollSystem{
    private List<Employee> EmployeeList;
    public payRollSystem(){
EmployeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
            EmployeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee emp : EmployeeList){
            if(emp.getId()==id){
                employeeToRemove=emp;
                break;
            }
        }
        if(employeeToRemove!=null){
            EmployeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee emp : EmployeeList){
            System.out.println(emp);
        }
    }

}


public class Main {
    public static void main(String[] args) {
        payRollSystem payRoll=new payRollSystem();
        FullTimeEmployee Emp1 =new FullTimeEmployee("vikash" , 1 , 70000.0);
        PartTimeEmployee Emp2=new PartTimeEmployee("Saurabh" , 2 , 5 , 100 );
        payRoll.addEmployee(Emp1);
        payRoll.addEmployee(Emp2);
        System.out.println("Initial Employee Details");
        payRoll.displayEmployees();
        System.out.println("Remove Employee : Successfully ");
        payRoll.removeEmployee(2);
        System.out.println("Remaining Employee");
        payRoll.displayEmployees();
    }
}

