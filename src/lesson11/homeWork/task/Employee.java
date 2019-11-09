package lesson11.homeWork.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании
class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class EmployeeSalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}
class EmployeeAgeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
class EmployeeCompanyComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}

public class Employee {
    public static void main(String[] args) {
        Comparator<Employee> employeeComparator = new EmployeeNameComparator();
        List<Employee> employeesSortedByName = employeeGenerator(10);
        employeesSortedByName.sort(employeeComparator);
        System.out.println(employeesSortedByName);

        employeeComparator = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator());
        List<Employee> employeesSortedByNameAndSalary = employeeGenerator(10);
        employeesSortedByNameAndSalary.sort(employeeComparator);
        System.out.println(employeesSortedByNameAndSalary);

        employeeComparator = new EmployeeNameComparator().thenComparing(new EmployeeAgeComparator()).thenComparing(new EmployeeCompanyComparator());
        List<Employee> employeesSortedByNameAndSalaryAndAgeAndCompany = employeeGenerator(10);
        employeesSortedByNameAndSalaryAndAgeAndCompany.sort(employeeComparator);
        System.out.println(employeesSortedByNameAndSalaryAndAgeAndCompany);
    }

    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[random.nextInt(names.length)],
                    companies[random.nextInt(companies.length)],
                    random.nextInt(2000) + 1000,
                    random.nextInt((60 - 21) + 1) + 21
            )); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }
}