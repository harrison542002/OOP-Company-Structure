import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    protected ArrayList<SoftwareEngineer> directReports = new ArrayList<SoftwareEngineer>();
    private int headCount;
    protected BusinessLead businessLead;

    public TechnicalLead(String name) {
        /*
        Should create a new TechnicalLead that is a Manager. The
        TechnicalLead's base salary should be 1.3 times that of a
        TechnicalEmployee. TechnicalLeads should have a default
        head count of 4.
         */

        super(name, (defaultSalary * 1.3)); //1.3 times that of a TechnicalEmployee
        headCount = 4; //default head count of 4
    }

    public boolean hasHeadCount() {
        /*
        Should return true if the number of direct reports this
        manager has is less than their headcount.
         */

        return directReports.size() < headCount;
    }

    ;

    public boolean addReport(SoftwareEngineer o) {
        /*
        Should accept the reference to a SoftwareEngineer object,
        and if the TechnicalLead has head count left should add this
        employee to their list of direct reports. If the employee is
        successfully added to the TechnicalLead's direct reports
        true should be returned, false should be returned otherwise
         */

        //if the TechnicalLead has head count left and code access is true
        if (hasHeadCount()) {

            //Add that employee to directReports lists
            directReports.add(o);

            //set manager for this direct report
            o.manager = this;

            return true;
        }

        return false;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        /*
        Should see if the employee passed in does report to this
        manager and if their code access is currently set to "true". If
        both those things are true, true is returned, otherwise false
        is returned
         */

        if (directReports.contains(e) && e.getCodeAccess()) {
            //if the employee passed in does report to this manager and if their code access is currently set to "true"
            return true;
        }
        //Otherwise, return false
        return false;

    }

    public boolean requestBonus(Employee e, double bonus) {

        /*
        Should check if the bonus amount requested would be
        approved by the BusinessLead supporting this
        TechnicalLead. If it is, that employee should get that bonus
        and true should be returned. False should be returned
        otherwise
         */

        return businessLead.requestBonus(e, bonus);
    }

    public String getTeamStatus() {

        if (directReports.size() == 0 || directReports == null) {
            /*
            If the TechnicalLead has no reports it
            should print their employee status followed by the text "
            and no direct reports yet ".
             */

            return this.employeeStatus() + " and no direct reports yet.";
        }

        //If the TechnicalLead does have reports
        String status = this.employeeStatus() + " and is managing: \n";
        for (SoftwareEngineer e : directReports) {

            //Iterate through all employees in direct reports list and concatenate each employee status
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
