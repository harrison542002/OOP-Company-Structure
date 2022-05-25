public abstract class TechnicalEmployee extends Employee{

    protected static final float defaultSalary = 7500;
    private int codeCheckIns;

    //Construct employee with name and has a default base salary of 75000
    public TechnicalEmployee(String name){
        super(name,defaultSalary);
        this.codeCheckIns = 0;
    }

    //Overloaded Constructor for convenience use if there is change in salary
    public TechnicalEmployee(String name, double salary){
        super(name,salary);
    }

    //Should return a String representation of this TechnicalEmployee
    @Override
    public String employeeStatus(){
        return getEmployeeId() + " " + getName() + " has " + getCodeCheckIns() +" successful check ins ";
    };

    public int getCodeCheckIns(){
        return this.codeCheckIns;
    }
    public void incrementCodeCheckIns(int num){
        this.codeCheckIns += num;
    }

    //This method with be implemented in concrete class as implementation will be distinct.
    @Override
    public abstract Employee getManager();
}
