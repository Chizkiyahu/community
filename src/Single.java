import java.util.Date;

public class Single extends CommunityMember {



    private int yearInScool;

    public Single(int id, Gender gender, String name, String address, String birthday, int leranToraHoursPerWeek, int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contribut) throws Exception {
        super(id, gender, name, address, birthday, leranToraHoursPerWeek, workHoursPerWeek, salary, exploitationOfRights, contribut);
    }


    public int getYearInScool() {
        return yearInScool;
    }

    public void setYearInScool(int yearInScool) {
        this.yearInScool = yearInScool;
    }


    @Override
    public int taxValue() {
        if(OK_USED_HOUERS_WEEK == this.getLeranToraHoursPerWeek())
            return 0;
        else
            return Math.max( 1000 + getWorkHoursPerWeek() * 10 , 0) ;
    }

    @Override
    public int maxEligibilityFromGMACH() {
        return 1000;
    }

    @Override
    public int recommendHoursVolunteer() {
        return 10;
    }
}
