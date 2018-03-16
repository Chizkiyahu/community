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
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }
}
