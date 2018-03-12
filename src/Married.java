import java.util.Date;

public class Married extends CommunityMember {




    public Married(int id, Gender gender, String name, String address, String birthday, int leranToraHoursPerWeek,
                   int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contribut,
                   int spouseId, int numChildUnder18) throws Exception {
        super(id, gender, name, address, birthday, leranToraHoursPerWeek, workHoursPerWeek, salary, exploitationOfRights, contribut);

        this.spouseId = spouseId;
        this.numChildUnder18 = numChildUnder18;
    }

    private int spouseId;

    public int getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(int spouseId) {
        this.spouseId = spouseId;
    }

    private int numChildUnder18;

    public int getNumChildUnder18() {
        return numChildUnder18;
    }

    public void setNumChildUnder18(int numChildUnder18) {
        this.numChildUnder18 = numChildUnder18;
    }


    @Override
    public int taxValue() {
        if(OK_USED_HOUERS_WEEK == this.getLeranToraHoursPerWeek())
            return 0;
        else
            return Math.max( 1000 + getWorkHoursPerWeek() * 10 - getNumChildUnder18() * 10 , 0) ;
    }

    @Override
    public int maxEligibilityFromGMACH() {
        return 1000 + getNumChildUnder18() * 1000;
    }

    @Override
    public int recommendHoursVolunteer() {
        return Math.max( 10 - getNumChildUnder18() , 2);
    }


}
