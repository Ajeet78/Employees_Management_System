import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class EmployeeManager {
    private List<Employee> employees;
    private int nextId;

    public EmployeeManager() {
        employees = new ArrayList<>();
        nextId = 1;
    }

    public void addEmployee(String name, String department, double salary) {
        Employee employee = new Employee(nextId, name, department, salary);
        employees.add(employee);
        nextId++;
        System.out.println("Employee added successfully!");
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employee.setSalary(newSalary);
            System.out.println("Employee salary updated successfully!");
        } else {
            System.out.println("Employee not found with the given ID.");
        }
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                employee.displayEmployeeDetails();
            }
        }
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    employeeManager.addEmployee(name, department, salary);
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    employeeManager.updateEmployeeSalary(id, newSalary);
                    break;
                case 3:
                    employeeManager.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
  