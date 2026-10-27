// Q02

// a)
class Membership {
    protected String membershipID;
    protected String memberName;
    protected int durationMonths;

    // a) i)
    public Membership() {
        this("N/A", "N/A", 0);
    }


    public Membership(String membershipID, String memberName,
                      int durationMonths) {
        this.membershipID = membershipID;
        this.memberName = memberName;
        this.durationMonths = durationMonths;
    }

    // a) ii)
    public void displayMembershipDetails() {
        System.out.println("Membership ID: " + membershipID);
        System.out.println("Member Name: " + memberName);
        System.out.println("Duration: " + durationMonths + " months");
    }

    // b) i)
    public double calculateFee() {
        return 5000.00;
    }

    // b) ii)
    public double calculateFee(double discountPercentage) {
        double fee = calculateFee();
        return fee - (fee * discountPercentage / 100.0);
    }
}

// c)
class BasicMembership extends Membership {
    private boolean hasGymAccess;

    // c) i)
    public BasicMembership() {
        super();
        hasGymAccess = true;
    }


    public BasicMembership(String membershipID, String memberName,
                           int durationMonths, boolean hasGymAccess) {
        super(membershipID, memberName, durationMonths);
        this.hasGymAccess = hasGymAccess;
    }

    // c) ii)
    @Override
    public double calculateFee() {
        return 200.0 * durationMonths;
    }

    // c) iii)
    @Override
    public void displayMembershipDetails() {
        super.displayMembershipDetails();
        System.out.println("Gym Access: " + hasGymAccess);
        System.out.println("Total Fee: $" + calculateFee());
    }
}

// d)
class PremiumMembership extends Membership {
    private boolean includePersonalTraining;

    // d) i)
    public PremiumMembership() {
        super();
        includePersonalTraining = false;
    }


    public PremiumMembership(String membershipID, String memberName,
                             int durationMonths,
                             boolean includePersonalTraining) {
        super(membershipID, memberName, durationMonths);
        this.includePersonalTraining = includePersonalTraining;
    }

    // d) ii)
    @Override
    public double calculateFee() {
        double fee = 300.0 * durationMonths;

        if (includePersonalTraining) {
            fee += 100.0;
        }

        return fee;
    }

    // d) iii)
    @Override
    public void displayMembershipDetails() {
        super.displayMembershipDetails();
        System.out.println("Personal Training Included: "
                + includePersonalTraining);
        System.out.println("Total Fee: $" + calculateFee());
    }
}

// e)
public class MembershipApp {
    public static void main(String[] args) {

        // e) i) - BasicMembership using default constructor
        BasicMembership basic = new BasicMembership();

        // e) ii) - PremiumMembership using parameterized constructor
        PremiumMembership premium = new PremiumMembership(
                "PM101", "Gimhana", 6, true
        );

        System.out.println("Basic Membership");

        // e) iv)
        basic.displayMembershipDetails();

        // e) iii)
        System.out.println("Fee: $" + basic.calculateFee());
        System.out.println("Discounted Fee (10%): $"
                + basic.calculateFee(10));

        System.out.println();
        System.out.println("Premium Membership");

        // e) iv)
        premium.displayMembershipDetails();

        // e) iii)
        System.out.println("Fee: $" + premium.calculateFee());
        System.out.println("Discounted Fee (20%): $"
                + premium.calculateFee(20));
    }
}