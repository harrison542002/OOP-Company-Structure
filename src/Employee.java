public abstract class Employee {
    private String name;
    private double baseSalary;
    private static int count = 1;
    protected double bonus = 0;
    private final int id;
    
    //Construct Employee with two parameters name and base salary
    public Employee(String name,double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        this.id = count++;
        //id will unique number for each employee as the "count" variable is incremented.
    }

    //Should return the employee's base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    //Should return the employee's name
    public String getName() {
        return name;
    }

    /*
    Should return the employee's ID.
    The ID should be issued on behalf of the employee at the
    time they are constructed. The first employee should have
    an ID of "1", the second "2" and so on
     */
    public int getEmployeeId() {
        return id;
    }

    //Should return true if the two employee’s ID are the same,
    //false otherwise
    public boolean equals(Employee person){
        if(this.id == person.id)
            return true;
        return false;
    }

    /*
    Should return a String representation of the employee that is a combination of their id followed by their name.
    Example: "1 Kasey"
     */
    @Override
    public String toString() {
        return id + " " +name;
    }

    /*
    Should return a String representation of that Employee's
    current status. This will be different for every subclass of
    Employee
     */
    public abstract String employeeStatus();

    /*
    Should return a reference to the Employee object that
    represents this employee's manager
     */
    public abstract Employee getManager();

    public int getBonus(){
        return (int) bonus;
    }
}
