package ru.verlyshev.homeworks.lesson15;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //1
        System.out.println(generateFromMinToMaxList(-5, 10));

        //2
        System.out.println(getSumElementsMore5(List.of(1, 3, 5, 6, 1, 6)));

        //3
        var list1 = new ArrayList<Integer>();
        {
            list1.add(1);
            list1.add(2);
        }
        replaceListValue(4, list1);
        System.out.println(list1);

        //4
        var list2 = new ArrayList<Integer>();
        {
            list2.add(3);
            list2.add(4);
        }
        increaseListValue(3, list2);
        System.out.println(list2);

        //5
        var employees = List.of(
                new Employee("Vasya", 30),
                new Employee("Petya", 35),
                new Employee("Kolya", 25)
        );
        System.out.println(getEmployeesNames(employees));

        //6
        getEmployeeOlderMinAge(employees, 30).forEach(System.out::println);

        //7
        System.out.println(isMoreThenAvgAge(employees, 30));

        //8
        System.out.println(getYoungestEmployee(employees));
    }

    static List<Integer> generateFromMinToMaxList(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            result.add(i);
        }

        return result;
    }

    static int getSumElementsMore5(List<Integer> list) {
        return list.stream().filter(v -> v > 5).mapToInt(v -> v).sum();
    }

    static void replaceListValue(int replacement, List<Integer> list) {
        list.replaceAll(v -> replacement);
    }

    static void increaseListValue(int enlarger, List<Integer> list) {
        list.replaceAll(v -> v + enlarger);
    }

    static List<String> getEmployeesNames(List<Employee> employees) {
        return employees.stream().map(Employee::getName).toList();
    }

    static List<Employee> getEmployeeOlderMinAge(List<Employee> employees, int minAge) {
        return employees.stream().filter(employee -> employee.getAge() >= minAge).toList();
    }

    static boolean isMoreThenAvgAge(List<Employee> employees, int minAvgAge) {
        return employees.stream().mapToInt(Employee::getAge).average().getAsDouble() > minAvgAge;
    }

    static Employee getYoungestEmployee(List<Employee> employees) {
        var youngestEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (youngestEmployee.getAge() > employee.getAge()) {
                youngestEmployee = employee;
            }
        }

        return youngestEmployee;
    }

}
