public abstract class CommunityMember implements DutiesAndRights{

    protected final int HOURS_IN_A_WEEK = 24 *7;
    protected final float PERCENT_OF_WEEK_ALLOWED = (float) (2.0 / 3.0);
    protected final  float HOURS_ALLOWED_PER_WEEK = HOURS_IN_A_WEEK * PERCENT_OF_WEEK_ALLOWED;

    public enum Gender {
        MALE, FEMALE
    }

    public enum ContributionType {
        SPIRITUALLY, PHYSICALLY, MUSICAL
    }

    protected int id;
    protected Gender gender;
    protected String name;
    protected String address;
    protected int hourAWeekSpentLearning;
    protected int hoursAWeekSpentWorking;
    protected float exploitationOfRights;
    protected float salary;
    protected String birthday ;
    protected ContributionType contributionType;

    public CommunityMember(int id, Gender gender, String name, String address, String birthday,int hourAWeekSpentLearning,
                           int workHoursPerWeek, float salary, float exploitationOfRights, ContributionType contributionType) throws Exception{
        setId(id);
        setGender(gender);
        setName(name);
        setAddress(address);
        setBirthday(birthday);
        setWorkPlusTorahHoursPerWeek(workHoursPerWeek, hourAWeekSpentLearning);
        setSalary(salary);
        setExploitationOfRights(exploitationOfRights);
        setContributionType(contributionType);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getHourAWeekSpentLearning() {
        return hourAWeekSpentLearning;
    }

    public int getHoursAWeekSpentWorking() {
        return hoursAWeekSpentWorking;
    }

    public void setHourAWeekSpentLearning(int hourAWeekSpentLearning) throws Exception {
        setWorkPlusTorahHoursPerWeek(hoursAWeekSpentWorking, hourAWeekSpentLearning);
    }

    public void setHoursAWeekSpentWorking(int hoursAWeekSpentWorking) throws Exception {
        setWorkPlusTorahHoursPerWeek(hoursAWeekSpentWorking, hourAWeekSpentLearning);
    }

    public void setWorkPlusTorahHoursPerWeek(int workHoursPerWeek, int learnHoursTorahPerWeek) throws Exception{
        if (workHoursPerWeek +  learnHoursTorahPerWeek == HOURS_ALLOWED_PER_WEEK){
            this.hoursAWeekSpentWorking = workHoursPerWeek;
            this.hourAWeekSpentLearning = learnHoursTorahPerWeek;
        }
        else throw new Exception("the torah and work isn't 2/3 from week");
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setExploitationOfRights(float exploitationOfRights) {
        this.exploitationOfRights = exploitationOfRights;
    }

    public ContributionType getContributionType() {
        return contributionType;
    }

    public void setContributionType(ContributionType contributionType) {
        this.contributionType = contributionType;
    }
}
