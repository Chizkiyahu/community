public  class DataForTest {

    public static void add(Community community) throws Exception {
        community.addMember(new Married(201123431, CommunityMember.Gender.MALE,
                "moshe","moshe choan beni break","1/1/1967",100,12,
                34217,23, CommunityMember.ContributionType.MUSICAL,2038179088,2));
        community.addMember(new Married(546646272, CommunityMember.Gender.MALE,
                "david","path takva","1/8/1967",12,100,
                3633,90, CommunityMember.ContributionType.MUSICAL,277655388,3));
        community.addMember(new Single(546208272, CommunityMember.Gender.MALE,
                "chezki","path takva","21/8/1988",12,100,
                77633,0, CommunityMember.ContributionType.PHYSICALLY));
        community.addMember(new Married(24363832, CommunityMember.Gender.FEMALE,
                "david","path takva","4/9/1990",12,100,
                983484,765, CommunityMember.ContributionType.SPIRITUALLY,277655388,3));
    }
}
