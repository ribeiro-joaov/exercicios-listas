package application;

import entities.Employee;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();


            Employee employee = new Employee(id, name, salary);

            list.add(employee);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();


        int finalIdSalary1 = idSalary;
        Employee emp = list.stream().filter(x -> x.getId() == finalIdSalary1).findFirst().orElse(null);

        while (emp == null) {
            System.out.println("This id does not exist, please type a valid id: ");
            idSalary = sc.nextInt();
            int finalIdSalary = idSalary;
            emp = list.stream().filter(x -> x.getId() == finalIdSalary).findFirst().orElse(null);
        }
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);

        System.out.println();
        System.out.println("List of employees: ");
        for (Employee employee : list){
            System.out.println(employee);
        }
        }

    }






