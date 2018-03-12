import java.util.Date;

public abstract class CommunityMember implements DutiesAndRights{

    protected final int HOUERS_WEEK = 24 *7;
    protected final float OK_PERSNET_USED = (float) (2.0 / 3.0);
    protected final  float OK_USED_HOUERS_WEEK = HOUERS_WEEK * OK_PERSNET_USED;

    public CommunityMember(int id, Gender gender, String name, String address, String birthday,int leranToraHoursPerWeek,
                           int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contribut) throws Exception{
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        if (workHoursPerWeek +  leranToraHoursPerWeek == OK_USED_HOUERS_WEEK){
            this.workHoursPerWeek = workHoursPerWeek;
            this.leranToraHoursPerWeek = leranToraHoursPerWeek;
        }
        else throw new Exception("the tora and work isn't 2/3 from week");
        this.salary = salary;
        this.exploitationOfRights = exploitationOfRights;
        this.contribut = contribut;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public enum Gender {
        MALE, FEMALE

    }

    private Gender gender;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    private  String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String birthday ;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private int leranToraHoursPerWeek;

    public int getLeranToraHoursPerWeek() {
        return leranToraHoursPerWeek;
    }

    private int workHoursPerWeek;

    public int getWorkHoursPerWeek() {
        return workHoursPerWeek;
    }

    public void setWorkPlusToraHoursPerWeek(int workHoursPerWeek, int leranHoursToraPerWeek) throws Exception{
        if (workHoursPerWeek +  leranHoursToraPerWeek == OK_USED_HOUERS_WEEK){
            this.workHoursPerWeek = workHoursPerWeek;
            this.leranToraHoursPerWeek = leranHoursToraPerWeek;
        }
        else throw new Exception("the tora and work isn't 2/3 from week");
    }

    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private float exploitationOfRights;

    public float getExploitationOfRights() {
        return exploitationOfRights;
    }

    public void setExploitationOfRights(float exploitationOfRights) {
        this.exploitationOfRights = exploitationOfRights;
    }

    public enum ContributionType {
        SPIRITUALLY, PHYSICALLY, MUSICAL
    }

    private ContributionType contribut;

    public ContributionType getContribut() {
        return contribut;
    }

    public void setContribut(ContributionType contribut) {
        this.contribut = contribut;
    }
}
