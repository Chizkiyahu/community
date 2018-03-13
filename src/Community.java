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


    public String VolunteerHoursReport(){
        String sp = "SPIRITUALLY \n";
        String ph = "\nPHYSICALLY \n";
        String mu = "\nMUSICAL \n";
        String temp;
        for (CommunityMember member : getCommunityMembers()) {
            temp = "";
            temp += member.getId();
            temp += "   ";
            temp += member.getName();
            temp += "   ";
            temp += member.recommendHoursVolunteer();
            if (member.getContribut().equals(CommunityMember.ContributionType.SPIRITUALLY)) {
                sp += temp;
            } else if (member.getContribut().equals(CommunityMember.ContributionType.PHYSICALLY)) {
                ph += temp;
            } else if (member.getContribut().equals(CommunityMember.ContributionType.MUSICAL)) {
                mu += temp;
            }
        }
        return sp + ph + mu + "\n\n";
    }
}
