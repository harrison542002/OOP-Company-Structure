import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {

    private ArrayList<Accountant> directReports = new ArrayList<Accountant>();

    private int headCount = 10;

    public BusinessLead(String name) {
        /*
        Should create a new BusinessLead that is a Manager. The
        BusinessLead's base salary should be twice that of an
        Accountant. They should start with a head count of 10.
         */

        super(name, defaultSalary * 2);
    }

    public boolean hasHeadCount() {
        /*
        Should return true if the number of direct reports this
        manager has is less than their headcount.
         */

        return directReports.size() < headCount;
    }

    public boolean addReport(Accountant accountant, TechnicalLead supportTeam) {

        //if head count is remaining
        if (directReports.size() <= headCount) {
            int bonusBudget = 0;

            //Add that accountant employee to lists of direct report
            directReports.add(accountant);

            //Add bonus budget 1.1 times that of new employee
            bonusBudget += accountant.getBaseSalary() * 1.1;
            incrementBonusBudget(bonusBudget);

            //Reflect supporting team for that accountant
            accountant.supportTeam(supportTeam);

            //Set business lead for that supporting team
            supportTeam.businessLead = this;

            //set manager for this direct report
            accountant.setManager(this);
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        //If the bonus amount requested would fit in current BusinessLead's budget
        if (bonus <= this.getBonusBudget()) {

            //give that bonus to that employee
            e.bonus = bonus;

            //deduct bonus budget with given bonus amount
            decrementBonusBudget(bonus);

            return true;
        }

        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        //Iterate through all direct reports in list
        for (Accountant directReport : directReports) {

            //If any direct report has the support team which the employee is in
            if (directReport.supportingTeam.directReports.contains(e)) {

                //If that accountant remains bonus budget greater than the bonus requested
                if (directReport.approveBonus(bonus)) {

                    //Reward bonus to that particular employee
                    e.bonus += bonus;
                    return true;
                }
            }
        }
        return false;
    }


    public String getTeamStatus() {

        //If there is no direct report!
        if (directReports.size() == 0 || directReports == null) {
            return this.employeeStatus() + " and no direct reports yet.";
        }

        //If the BusinessLead does have reports
        String status = this.employeeStatus() + " and is managing: \n";

        //Iterate through all direct reports
        for (Accountant e : directReports) {

            //Concatenate each direct report's employee status
            status += e.employeeStatus() + "\n";
        }

        //Return final concatenated string
        return status;

    }

    @Override
    public Employee getManager() {
        return this;
    }
}
