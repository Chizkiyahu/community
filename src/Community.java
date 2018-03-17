import java.util.ArrayList;
import java.util.List;


public class Community {

    private List<CommunityMember> communityMembers;

    public Community() {
        this.communityMembers = new ArrayList<CommunityMember>();
    }

    public List<CommunityMember> getCommunityMembers() {
        return communityMembers;
    }

    public void addMember(CommunityMember newMember){
        this.communityMembers.add(newMember);
    };

    public int getTaxReport(){
        int sum = 0;
        for (CommunityMember member : getCommunityMembers()) {
            sum+= member.taxValue();
        }
        return sum;
    }

    public int loanApplication(int id) throws Exception {
        for (CommunityMember member : communityMembers) {
            if (member.getId() ==  id){
                return member.maxEligibilityFromGMACH();
            }
        }
        throw new Exception("the member id not found");
    }


    public String getVolunteerHoursReport(){
        String sp = "SPIRITUALLY \n";
        String ph = "\nPHYSICALLY \n";
        String mu = "\nMUSICAL \n";
        String temp;
        for (CommunityMember member : getCommunityMembers()) {
            temp = "ID: ";
            temp += member.getId();
            temp += "   name: ";
            temp += member.getName();
            temp += "   recommend hours volunteer: ";
            temp += member.recommendHoursVolunteer();
            temp += "\n";

            switch (member.getContributionType()) {
                case     MUSICAL: mu += temp; break;
                case  PHYSICALLY: ph += temp; break;
                case SPIRITUALLY: sp += temp; break;
            }
        }
        return sp + "\n" + ph + "\n" + mu + "\n\n";
    }

    @Override
    public String toString() {
        String temp = new   String ();
        int test = 0;
        for (CommunityMember member : this.getCommunityMembers()) {
            temp += member.toString();
            test++;
        }
        return temp;
    }
}
