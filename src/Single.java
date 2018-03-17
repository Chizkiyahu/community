import java.lang.reflect.Field;

public class Single extends CommunityMember {

    protected int yearsInSchool;

    public Single(int id, Gender gender, String name, String address, String birthday, int leranToraHoursPerWeek, int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contribut) throws Exception {
        super(id, gender, name, address, birthday, leranToraHoursPerWeek, workHoursPerWeek, salary, exploitationOfRights, contribut);
    }


    public int getYearsInSchool() {
        return yearsInSchool;
    }

    public void setYearsInSchool(int yearsInSchool) {
        this.yearsInSchool = yearsInSchool;
    }


    @Override
    public int taxValue() {
        if(HOURS_ALLOWED_PER_WEEK == this.getHourAWeekSpentLearning())
            return 0;
        else
            return Math.max( 1000 + getHoursAWeekSpentWorking() * 10 , 0) ;
    }

    @Override
    public int maxEligibilityFromGMACH() {
        return 1000;
    }

    @Override
    public int recommendHoursVolunteer() {
        return 10;
    }

    @Override
    public String toString() {
        String temp = new String();
        temp += "yearsInSchool: " + getYearsInSchool();
        return super.toString() + temp;
    }
}
