class EmployeeImportance{
public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        
        
        for(Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        
        Employee employeeImportance = employeeMap.get(id);
        
        Queue<Employee> q = new LinkedList<>();
        Set<Employee> visited = new HashSet<>();
        q.add(employeeImportance);
        
        int count = 0;
        while(!q.isEmpty()) {
            Employee current = q.poll();
            
            if (!visited.contains(current)) {
                count += current.importance;
                visited.add(current);
                for(Integer sub : current.subordinates) {
                    q.add(employeeMap.get(sub));
                }
            }
        }
        
        return count;
    }
	}