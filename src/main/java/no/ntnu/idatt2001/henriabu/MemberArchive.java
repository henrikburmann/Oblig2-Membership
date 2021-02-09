package no.ntnu.idatt2001.henriabu;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    public int findPoints(int memberNumber, String password){
        String memberCode = memberNumber + password;
        String memberCode2 = "";
        if (memberExists(memberNumber)){
            memberCode2 = members.get(memberNumber) + members.get(memberNumber).getPassword();
            if (memberCode.equals(memberCode2)){
                return members.get(memberNumber).getBonusPointsBalance();
            }
        }
        return -1;
    }
    private boolean memberExists(int memberNumber){
        for (BonusMember member: members.values()){
            if (member.getMemberNumber() == memberNumber){
                return true;
            }
        }
        return false;
    }
    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = true;
        for (BonusMember member: members.values()){
            if (bonusMember.equals(member)){
                success = false;
            }
        }
        members.put(bonusMember.getMemberNumber(), bonusMember);
        return success;
    }


    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        return memberExists(memberNumber);
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        System.out.println(toString());
        System.out.print("The total number of members is " + members.size());
    }

    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("Members:\n");
        for (BonusMember member: members.values()){
            text.append(member.toString());
        }
        return text.toString();
    }
    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member1 = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        BonusMember member2 = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        BonusMember member3 = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        BonusMember member4 = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        BonusMember member5 = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        addMember(member1);
        addMember(member2);
        addMember(member3);
        addMember(member4);
        addMember(member5);
    }

}