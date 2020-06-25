package lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class lambdaTest {
    @BeforeEach
    void setUp() {
    }
    @Test
    void employeeStream(){
        Employee[] employees = {
                new Employee("Jimoh", "Ahmed", "IT", 5000),
                new Employee("Odeku", "Odenson", "IT", 7600),
                new Employee("Omosare", "Omogbagi", "Sales", 3587.5),
                new Employee("James", "Jameson", "Marketing", 4700.77),
                new Employee("Luk", "Lukmon", "IT", 6200),
                new Employee("Ikare", "Omo", "Sales", 3200)
        };
        List<Employee> employeeList = Arrays.asList(employees);
        System.out.println("Complete list of employees");
        employeeList.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand =
                e ->(e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nEmployees earning $4000-6000 per month sorted by salary:%n");
        employeeList.stream().filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                employeeList.stream().filter(fourToSixThousand)
                .findFirst().get()
        );
    }
    @Test
    void newTest(){

    }
}
