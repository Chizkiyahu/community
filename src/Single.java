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
