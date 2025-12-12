public class MemberRegistration {
    private String memberID;
    private String name;
    private int creditPoint;

    public MemberRegistration() {

    }

    public MemberRegistration(String memberID, String name, int creditPoint) {
        this.memberID = memberID;
        this.name = name;
        this.creditPoint = creditPoint;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void addCreditPoint(int addPoint) {
        this.creditPoint = creditPoint + addPoint;
    }

    public void deductCreditPoint(int deductPoint) {
        this.creditPoint = creditPoint - deductPoint;
    }
}