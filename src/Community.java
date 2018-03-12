import java.util.Collections;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Community {

    public static void main(String[] args) {
        int menuchoice;
        Scanner in = new Scanner(System.in);
        listMember = new ArrayList<CommunityMember>();
        do {
            System.out.println("Please enter your choice");
            System.out.println("0 : Exit");
            System.out.println("1 : Add memeber ");
            System.out.println("2 : Tax report");
            System.out.println("3 : Loan application");
            System.out.println("4 : Volunteer hours report");
            try {
                menuchoice = in.nextInt();
            }catch (Exception ex ){
                System.out.println("Input Error");
                menuchoice =  -1;
                in.nextLine();
            }

            int id;
            CommunityMember.Gender gender;
            String name;
            String address;
            String birthday;
            int leranToraHoursPerWeek;
            int workHoursPerWeek;
            float salary;
            float exploitationOfRights;
            CommunityMember.ContributionType contributionType;
            int spouseId;
            int numChildUnder18;

            switch (menuchoice){
                case 0:
                    break;
                case 1:

                    try {
                        System.out.println("Please enter ID");
                        id = in.nextInt();
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }
                    try {
                        System.out.println("Please enter gender");
                        System.out.println("1 : male");
                        System.out.println("2 : female");
                        int intGender = in.nextInt();
                        if (intGender == 1){
                            gender = CommunityMember.Gender.MALE;
                        }
                        else if (intGender == 2){
                            gender = CommunityMember.Gender.FEMALE;
                        }
                        else {
                            System.out.println("Error input");
                            break;
                        }
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    System.out.println("Please enter the name");
                    name = in.nextLine();
                    // for bug skip line problem in keybord buffer
                    name = in.nextLine();

                    System.out.println("Please enter the address");
                    address = in.nextLine();

                    System.out.println("Please enter the birthday");
                    birthday = in.nextLine();

                    try {
                        System.out.println("Please enter leran tora hours per week");
                        leranToraHoursPerWeek = in.nextInt();
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    try {
                        System.out.println("Please enter work hours per week");
                        workHoursPerWeek = in.nextInt();
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    try {
                        System.out.println("Please enter salary");
                        salary = in.nextInt();
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    try {
                        System.out.println("Please enter exploitation of rights");
                        exploitationOfRights = in.nextInt();
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    try {
                        System.out.println("Please enter Contribution Type");
                        System.out.println("1 : SPIRITUALLY");
                        System.out.println("2 : PHYSICALLY");
                        System.out.println("3 : MUSICAL");
                        int intContribution = in.nextInt();
                        if (intContribution == 1){
                            contributionType = CommunityMember.ContributionType.SPIRITUALLY;
                        }
                        else if (intContribution == 2){
                            contributionType = CommunityMember.ContributionType.PHYSICALLY;
                        }
                        else if (intContribution == 3){
                            contributionType = CommunityMember.ContributionType.MUSICAL;
                        }
                        else{
                            System.out.println("Error input");
                            break;
                        }
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }

                    try {
                        System.out.println("Please enter the status");
                        System.out.println("1 : Single");
                        System.out.println("2 : Marrid");
                        int status = in.nextInt();
                        if ( status == 1 ){
                            try {
                                listMember.add(new Single(id, gender , name, address, birthday, leranToraHoursPerWeek,
                                        workHoursPerWeek, salary, exploitationOfRights, contributionType));
                            }catch (Exception ex){
                                System.out.print(ex.getMessage());
                            }

                            break;

                        }
                        if (status == 2 ){
                            try {
                                System.out.println("Please enter spouse Id");
                                spouseId = in.nextInt();
                            }catch (Exception ex){
                                System.out.println("Error input");
                                break;
                            }
                            try {
                                System.out.println("Please enter number of Child Under 18");
                                numChildUnder18 = in.nextInt();
                            }catch (Exception ex){
                                System.out.println("Error input");
                                break;
                            }
                            try {
                            listMember.add(new Married(id, gender , name, address, birthday, leranToraHoursPerWeek,
                                    workHoursPerWeek, salary, exploitationOfRights, contributionType, spouseId, numChildUnder18));
                            }catch (Exception ex){
                                System.out.print(ex.getMessage());
                            }
                            break;
                        }
                    }catch (Exception ex){
                        System.out.println("Error input");
                        in.nextLine();
                        break;
                    }
                    break;
                case 2:
                    System.out.printf("the sum of tax is %d\n", getTaxReport());
                    break;
                case 3:
                    try {
                        try {
                            System.out.println("Please enter ID");
                            id = in.nextInt();
                        }catch (Exception ex){
                            System.out.println("Error input");
                            in.nextLine();
                            break;
                        }
                        System.out.printf("the munber to Loan is %d\n", loanApplication(id));
                    }
                    catch (Exception  ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case 4:
                    String list = VolunteerHoursReport();
                    System.out.print("the list is \n");
                    System.out.print(list);
                    break;
                    default:
                        System.out.println("Error input");
                        break;


            }

        }while (menuchoice != 0);
    }
    private static List<CommunityMember> listMember;
    protected void addMember(){

    };

    public static List<CommunityMember> getListMember() {
        return listMember;
    }

    public static int getTaxReport(){
        int sum = 0;
        for (CommunityMember member :getListMember()) {
            sum+= member.taxValue();
        }
        return sum;
    }

    public static int loanApplication(int id) throws Exception{
        for (CommunityMember member :listMember) {
            if (member.getId() ==  id){
                return member.maxEligibilityFromGMACH();
            }
        }
        throw new Exception("the member id not found");
    }


    public static String VolunteerHoursReport(){
        String sp = "SPIRITUALLY \n";
        String ph = "\nPHYSICALLY \n";
        String mu = "\nMUSICAL \n";
        String temp;
        for (CommunityMember member :getListMember()) {
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
