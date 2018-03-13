import java.util.ArrayList;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        int menuChoice;
        Scanner in = new Scanner(System.in);
        Community community = new Community();

        do {
            System.out.println("Please enter your choice");
            System.out.println("0 : Exit");
            System.out.println("1 : Add member ");
            System.out.println("2 : Tax report");
            System.out.println("3 : Loan application");
            System.out.println("4 : Volunteer hours report");

            try {
                menuChoice = in.nextInt();
            }catch (Exception ex ){
                System.out.println("Input Error");
                menuChoice =  -1;
                in.nextLine();
            }

            switch (menuChoice){
                case 0:
                    break;
                case 1:
                    doAddMemberAction(in, community);
                    break;
                case 2:
                    System.out.printf("the sum of tax is %d\n", community.getTaxReport());
                    break;
                case 3:
                    doLoanApplicationAction(in, community);
                    break;
                case 4:
                    String list = community.VolunteerHoursReport();
                    System.out.print("the list is \n");
                    System.out.print(list);
                    break;
                default:
                    System.out.println("Error input");
                    break;
            }

        } while (menuChoice != 0);
    }

    private static void doLoanApplicationAction(Scanner in, Community community) {
        int id;
        try {
            System.out.println("Please enter ID");
            id = in.nextInt();

            try {
                System.out.printf("the number to Loan is %d\n", community.loanApplication(id));
            }
            catch (Exception  ex) {
                System.out.print(ex.getMessage());
            }
        }catch (Exception ex){
            System.out.println("Error input");
            in.nextLine();
        }
    }

    private static void doAddMemberAction(Scanner in, Community community) {
        int id;
        CommunityMember.Gender gender;
        String name;
        String address;
        String birthday;
        int hourPerWeekOfTorahLearning;
        int workHoursPerWeek;
        float salary;
        float exploitationOfRights;
        CommunityMember.ContributionType contributionType;
        int spouseId;
        int numChildUnder18;

        try {
            // get member ID
            System.out.println("Please enter ID");
            id = in.nextInt();

            // get member gender
            System.out.println("Please enter gender");
            System.out.println("1 : male");
            System.out.println("2 : female");
            int intGender = in.nextInt();
            switch (intGender) {
                case 1: gender = CommunityMember.Gender.MALE;
                    break;
                case 2: gender = CommunityMember.Gender.FEMALE;
                    break;

                    default:
                        throw new Exception("No such gender");
            }

            // get member name
            System.out.println("Please enter the name");
            name = in.nextLine();
            // for bug skip line problem in keybord buffer
            name = in.nextLine();

            // get member address
            System.out.println("Please enter the address");
            address = in.nextLine();

            // get member birthday
            System.out.println("Please enter the birthday");
            birthday = in.nextLine();

            // get hours of Torah learning per week
            System.out.println("Please enter hours of Torah learning per week");
            hourPerWeekOfTorahLearning = in.nextInt();

            // get hour of work per week
            System.out.println("Please enter work hours per week");
            workHoursPerWeek = in.nextInt();

            // get salary
            System.out.println("Please enter salary");
            salary = in.nextInt();

            // get exploitation of rights
            System.out.println("Please enter exploitation of rights");
            exploitationOfRights = in.nextInt();

            // get contribution type
            System.out.println("Please enter Contribution Type");
            System.out.println("1 : SPIRITUALLY");
            System.out.println("2 : PHYSICALLY");
            System.out.println("3 : MUSICAL");
            int intContribution = in.nextInt();

            switch (intContribution) {
                case 1:
                    contributionType = CommunityMember.ContributionType.SPIRITUALLY;
                    break;
                case 2:
                    contributionType = CommunityMember.ContributionType.PHYSICALLY;
                    break;
                case 3:
                    contributionType = CommunityMember.ContributionType.MUSICAL;
                    break;
                    default:
                        throw new Exception("No such contribution type");
            }

            // get status
            System.out.println("Please enter the status");
            System.out.println("1 : Single");
            System.out.println("2 : Married");
            int status = in.nextInt();

            if (status == 1) {
                try {
                    community.addMember(new Single(id, gender , name, address, birthday, hourPerWeekOfTorahLearning,
                            workHoursPerWeek, salary, exploitationOfRights, contributionType));
                }catch (Exception ex) {
                    System.out.print(ex.getMessage());
                }
            }
            else if (status == 2) {
                // get spouse ID
                System.out.println("Please enter spouse Id");
                spouseId = in.nextInt();

                // get # of children < 13
                System.out.println("Please enter number of Child Under 18");
                numChildUnder18 = in.nextInt();

                try {
                    community.addMember(new Married(id, gender , name, address, birthday, hourPerWeekOfTorahLearning,
                            workHoursPerWeek, salary, exploitationOfRights, contributionType, spouseId, numChildUnder18));
                }catch (Exception ex){
                    System.out.print(ex.getMessage());
                }

            }

        }catch (Exception ex){
            System.out.println("input error");
            in.nextLine();
        }
    }
}