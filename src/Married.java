import java.lang.reflect.Field;

public class Married extends CommunityMember {

    protected int spouseId;
    protected int numberOfChildrenUnderEighteen;

    public Married(int id, Gender gender, String name, String address, String birthday, int leranToraHoursPerWeek,
                   int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contribut,
                   int spouseId, int numChildUnder18) throws Exception {
        super(id, gender, name, address, birthday, leranToraHoursPerWeek, workHoursPerWeek, salary, exploitationOfRights, contribut);

        setSpouseId(spouseId);
        setNumberOfChildrenUnderEighteen(numChildUnder18);
    }


    public int getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(int spouseId) {
        this.spouseId = spouseId;
    }

    public int getNumberOfChildrenUnderEighteen() {
        return numberOfChildrenUnderEighteen;
    }

    public void setNumberOfChildrenUnderEighteen(int numberOfChildrenUnderEighteen) {
        this.numberOfChildrenUnderEighteen = numberOfChildrenUnderEighteen;
    }

    @Override
    public int taxValue() {
        if(HOURS_ALLOWED_PER_WEEK == this.getHourAWeekSpentLearning())
            return 0;
        else
            return Math.max( 1000 + getHoursAWeekSpentWorking() * 10 - getNumberOfChildrenUnderEighteen() * 10 , 0) ;
    }

    @Override
    public int maxEligibilityFromGMACH() {
        return 1000 + getNumberOfChildrenUnderEighteen() * 1000;
    }

    @Override
    public int recommendHoursVolunteer() {
        return Math.max( 10 - getNumberOfChildrenUnderEighteen() , 2);
    }


    @Override
    public String toString() {
        String temp = new String();
        temp += "\tspouseId: " + getSpouseId();
        temp += "\tnumberOfChildrenUnderEighteen: " + getNumberOfChildrenUnderEighteen();
        return super.toString() + temp;
    }

}
