public class RegularMember extends GymMember {
    // Private attributes
    private final int ATTENDANCE_LIMIT = 30;
    private boolean eligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor
    public RegularMember(String id, String name, String location, String phone, String email, String gender, String dob, String membershipStartDate, String referralSource, String removalReason, String plan) {
        super(id, name, location, phone, email, gender, dob, membershipStartDate);
        this.referralSource = referralSource;
        this.eligibleForUpgrade = false;
        this.plan = plan;  // Plan passed as argument
        this.price = getPlanPrice(plan);  // Get the price based on the plan
        this.removalReason = removalReason;
    }

    // Getters
    public int getAttendanceLimit() { return ATTENDANCE_LIMIT; }
    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public String getRemovalReason() { return removalReason; }
    public String getReferralSource() { return referralSource; }
    public String getPlan() { return plan; }
    public double getPrice() { return price; }

    // Implementing markAttendance method
    @Override
    public void markAttendance() {
        attendance++;
        loyalityPoints += 5;
        if (attendance >= ATTENDANCE_LIMIT) {
            eligibleForUpgrade = true;
        }
    }

    // Getting plan price
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default:
                System.out.println("Invalid plan selected.");
                return -1;
        }
    }

    // Upgrading plan
    public String upgradePlan(String newPlan) {
        if (!eligibleForUpgrade) {
            return "Member is not eligible for upgrade.";
        }
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "You are already subscribed to this plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selection.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " with price " + newPrice;
    }

    // Reverting RegularMember
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.eligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Displaying member details
    @Override
    public void display() {
        super.display();
        String memberDetails = "Plan: " + plan + "\n" +
                               "Price: " + price + "\n" +
                               (removalReason.isEmpty() ? "" : "Removal Reason: " + removalReason);
        System.out.println("Removal Reason" + removalReason);
    }
}
