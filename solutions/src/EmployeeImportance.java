import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeImportance {
    //https://leetcode.com/problems/employee-importance/description/
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return -1; //maybe a throw??
        }
        //O(n)
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.id, Function.identity()));
        if (!employeeMap.containsKey(id)) {
            return -1;
        }
        List<Employee> inEmploy = new LinkedList<>();
        inEmploy.add(employeeMap.get(id));
        int totalImportance = 0;
        do {
            totalImportance += inEmploy.stream().mapToInt(e -> e.importance).sum();
            System.out.println(inEmploy.size());
            inEmploy = inEmploy.stream().flatMap(e -> {
                System.out.println(e.subordinates.size());
                return e.subordinates.stream();
            }).map(eId -> employeeMap.get(eId)).collect(Collectors.toList());
        } while (!inEmploy.isEmpty()); //O(log(n))
        return  totalImportance;
    }



}
