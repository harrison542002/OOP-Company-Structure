public class SoftwareEngineer extends TechnicalEmployee {

    private boolean codeAccess;
    private int codeCheckIns;
    protected TechnicalLead manager;

    public SoftwareEngineer(String name) {
        //Should start without access to code and with 0 code check ins

        super(name);
        this.codeAccess = false;
        this.codeCheckIns = 0;
    }


    public boolean getCodeAccess() {
        /*
        Should return whether or not this SoftwareEngineer has access to
        make changes to the code base
        */
        return codeAccess;
    }

    public int getSuccessfulCheckIns() {
        /*
        Should return the current count of how many times this
        SoftwareEngineer has successfully checked in code
         */
        return codeCheckIns;
    }

    public boolean checkInCode() {
        /*
        Should check if this SoftwareEngineer's manager approves of their
        check in. If the check in is approved their successful check in count
        should be increased and the method should return "true". If the
        manager does not approve the check in the SoftwareEngineer's code
        access should be changed to false and the method should return "false"
        */

        if (manager.approveCheckIn(this)) {
            this.incrementCodeCheckIns(1);
            return true;
        } else {
            codeAccess = false;
            return false;
        }
    }


    public void setCodeAccess(boolean codeAccess) {
        /*
        Should allow an external piece of code to update the
        SoftwareEngieer's code privileges to either true or false
        */

        this.codeAccess = codeAccess;
    }

    @Override
    public TechnicalLead getManager() {
        //Get manager of this Software Engineer

        return manager;
    }
}
