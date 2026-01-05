import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreamSapientTest {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering", 90000, 28,
                        Arrays.asList("Java", "Spring", "SQL", "Docker"), 3),
                new Employee("Bob", "Engineering", 110000, 35,
                        Arrays.asList("Java", "Microservices", "AWS", "Kubernetes"), 7),
                new Employee("Charlie", "Engineering", 95000, 30,
                        Arrays.asList("Python", "JavaScript", "React"), 4),
                new Employee("Diana", "HR", 75000, 42,
                        Arrays.asList("Recruiting", "Communication", "Training"), 10),
                new Employee("Eve", "HR", 80000, 38,
                        Arrays.asList("Recruiting", "Analytics", "Excel"), 8),
                new Employee("Frank", "Sales", 85000, 45,
                        Arrays.asList("Negotiation", "CRM", "Presentation"), 12),
                new Employee("Grace", "Sales", 120000, 40,
                        Arrays.asList("Negotiation", "Leadership", "Strategy"), 15),
                new Employee("Henry", "Engineering", 130000, 50,
                        Arrays.asList("Java", "Architecture", "Cloud", "Kubernetes", "AI"), 20),
                new Employee("Ivy", "Engineering", 70000, 25,
                        Arrays.asList("Java", "Spring Boot", "MySQL"), 2),
                new Employee("Jenny", "Finance", 100000, 29,
                        Arrays.asList("CA", "CPA", "CPM"), 2),
                new Employee("James", "Finance", 85000, 32,
                        Arrays.asList("ICWA", "CPA", "Trading"), 8));

        // TODO: Solve the complex analytics problem below
        employeeAnalytics(employees);

    }

    public static void employeeAnalytics(List<Employee> employees) {
        /*
         * PROBLEM:
         * Find the top 2 departments with the highest average salary
         * for employees aged 30-45 who have at least 3 skills and know "Java" OR
         * "Cloud"
         * BUT exclude departments where the highest paid employee makes more than 200k
         * AND for those departments, return a map of:
         * Key: Department name
         * Value: Comma-separated string of employee names sorted by years in company
         * (descending)
         * with their salary in parentheses
         * 
         * Expected output format:
         * Engineering: Bob(7 years)-$110000, Charlie(4 years)-$95000
         */

        Map<String, String> result = employees.stream()
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 45)
                .filter(e -> e.getSkills().size() >= 3)
                .filter(e -> e.getSkills().contains("Java") || e.getSkills().contains("Cloud"))
                .collect(Collectors.groupingBy(e -> e.getDepartment(), LinkedHashMap::new, Collectors.toList()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .mapToDouble(Employee::getSalary).max().orElse(0) <= 200000)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .mapToDouble(Employee::getSalary).average().orElse(0)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(2)
                .sorted(Map.Entry.comparingByValue()) // stable sort if averages equal (optional)

                // Now build the final map with the required value format
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            String dept = entry.getKey();
                            // Get the original filtered employees for this department
                            List<Employee> deptEmployees = employees.stream()
                                    .filter(e -> e.getAge() >= 30 && e.getAge() <= 45)
                                    .filter(e -> e.getSkills().size() >= 3)
                                    .filter(e -> e.getSkills().contains("Java") || e.getSkills().contains("Cloud"))
                                    .filter(e -> e.getDepartment().equals(dept))
                                    .sorted(Comparator.comparingInt(Employee::getYearsInCompany).reversed())
                                    .collect(Collectors.toList());

                            return deptEmployees.stream()
                                    .map(e -> e.getName() + "(" + e.getYearsInCompany() + " years)-$"
                                            + (int) e.getSalary())
                                    .collect(Collectors.joining(", "));
                        },
                        (a, b) -> a, // merge function (not needed since keys are unique)
                        LinkedHashMap::new // preserve order (top 2 by avg salary)
                ));

            System.out.println(result);

    }
}

class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> skills;
    private int yearsInCompany;

    public Employee(String name, String department, double salary, int age, List<String> skills, int yearsInCompany) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.skills = skills;
        this.yearsInCompany = yearsInCompany;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    @Override
    public String toString() {
        return name + "(" + department + ")" + " - $" + salary;
    }
}
