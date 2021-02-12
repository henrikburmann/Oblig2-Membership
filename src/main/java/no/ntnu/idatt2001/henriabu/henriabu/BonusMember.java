package no.ntnu.idatt2001.henriabu.henriabu;

import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress){
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        checkAndSetMemberShip();
        this.name = name;
        this.eMailAddress = eMailAddress;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String getMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public boolean checkPassword(String password){
        if (password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }

    public void registerBonusPoints(int newPoints){
        bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance, newPoints);
        checkAndSetMemberShip();
    }


    private void checkAndSetMemberShip(){
        if(bonusPointsBalance<SILVER_LIMIT){
            membership = new BasicMembership();
        }
        else if (bonusPointsBalance>=SILVER_LIMIT && bonusPointsBalance< GOLD_LIMIT){
            membership = new SilverMembership();
        }
        else{
            membership = new GoldMemberShip();
        }
    }

    public String getMemberShipLevel(){
        return membership.getMembershipName();
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        else if (!(o instanceof BonusMember)){
            return false;
        }
        BonusMember member = (BonusMember) o;
        return member.getMemberNumber() == this.memberNumber;
    }

    public String toString(){
        return "Membernumber " + memberNumber + "\nName: " + name + "\nMembership: "
                + getMemberShipLevel() + "\nBonus point balance: " + bonusPointsBalance +
                "\nEmail Adress: " + eMailAddress + "\n\n";
    }
}
