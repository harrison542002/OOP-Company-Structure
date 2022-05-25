public class Accountant extends BusinessEmployee {
    private BusinessLead manager;
    protected TechnicalLead supportingTeam;

    public Accountant(String name) {
        /*
        Should start with a bonus budget of 0 and no team they are
        officially supporting
        */

        super(name);
        this.supportingTeam = null;
    }

    public TechnicalLead getTeamSupported() {
        /*
        Should return a reference to the TechnicalLead that this Accountant
        is currently supporting. If they have not been assigned a
        TechnicalLead null should be returned
         */

        return this.supportingTeam;
    }


    public void supportTeam(TechnicalLead lead) {
        /*
        Should allow a reference to a TechnicalLead to be passed and
        saved. Once this happens the Accountant's bonus budget should be
        updated to be the total of each SoftwareEngineer's base salary that
        reports to that TechnicalLead plus 10%. For example, if the
        TechnicalLead supports 2 SoftwareEngineers, each with a salary of
        75000, the Accountant's budget should be 150000 + 15000 for a
        total of 165000
         */

        double totalSalary = 0;

        //Loop over directReports list of supporting team
        for (SoftwareEngineer directReport : lead.directReports) {

            //Add individual base salary to total salary
            totalSalary += directReport.getBaseSalary();

        }

        //Total base salary of direct reports from supporting team and 10% of it.
        totalSalary = (totalSalary + (totalSalary * 0.1));
        incrementBonusBudget(totalSalary);
        supportingTeam = lead;
    }

    public boolean approveBonus(double bonus) {
        /*
        Should take in a suggested bonus amount and check if there is still
        enough room in the budget. If the bonus is greater than the
        remaining budget, false should be returned, otherwise true. If the
        accountant is not supporting any team false should be returned.
         */

        //If there is still enough room for budget and has the supporting team
        if (bonus <= this.getBonusBudget() && supportingTeam != null) {

            this.decrementBonusBudget(bonus);
            //Approve that bonus and abstract this amount of bonus from remaining bonus budget.

            return true;
        }

        return false;
        //Otherwise, return false
    }


    @Override
    public String employeeStatus() {

        //Define employ status
        return super.employeeStatus() + " is supporting " + supportingTeam.getName();

    }

    public void setManager(BusinessLead lead) {
        //Set manager of this employee using this method (only BussinessLead object is acceptable

        this.manager = lead;
    }

    @Override
    public Employee getManager() {
        //Get manager of this employee
        return this.manager;
    }
}
