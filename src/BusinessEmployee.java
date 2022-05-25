public abstract class BusinessEmployee extends Employee {
    protected static final float defaultSalary = 50000;
    private double bonusBudget = 0;

    //Construct employee with name and has a default base salary of 50000
    public BusinessEmployee(String name){
        //Constructor
        super(name,defaultSalary);
    }

    //Overloaded Constructor for convenience use if there is any change in salary
    public BusinessEmployee(String name, float salary){
        //Constructor
        super(name,salary);
    }

    /*
    Should establish a running tally of the remaining bonusBudget
    for the team this employee supports. How that budget is
    determined will depend on which type of Business Employee.
     */
    public double getBonusBudget(){
        return this.bonusBudget;
    };

    public void incrementBonusBudget(double val){
        this.bonusBudget += val;
    }

    public void decrementBonusBudget(double val){
        this.bonusBudget -= val;
    }

    /*
    Should return a String representation of this BusinessEmployee
    that includes their ID, name and the size of their currently
    managed budget.
     */
    public String employeeStatus() {
        return getEmployeeId() + " " + getName() + " with a budget of " + String.format("%.1f",bonusBudget);
    }

    //Get manager method will be abstract method as each type of employee will have distinct manager
    @Override
    public abstract Employee getManager();
}
