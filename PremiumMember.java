public class PremiumMember extends GymMember {
    private double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(String MemberId, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(MemberId, name, location, phone, email, gender, DOB, membershipStartDate);
        
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 50000;
        this.discountAmount = 5000;
    }
    
    //accesor method for attributes(getters method)
    public double premiumCharge () {
        return premiumCharge;
    }
    public String getPersonalTrainer() {
        return personalTrainer;
    }
    public boolean getFullpayment () {
        return isFullPayment;
    }
    public double getpaidAmount() {
        return paidAmount;
    }
    public double getdiscountAmount () {
        return discountAmount ;
    }
    // Pay due amount method with validation
    public String payDueAmount(double amount) {
       if (this.isFullPayment == true ){
           return "Payment is already done.No more payment requred till now.";
       }
       if (this.paidAmount > this.premiumCharge) {
           
           return "Error:Paid amount exceeds the premium charge";
           
       }
       //calculating the remaining amount 
       double remainingAmount = premiumCharge - this.paidAmount;
       
       if(this.paidAmount == premiumCharge) {
           isFullPayment = true;
           
       } else {
           isFullPayment = false;
       }
       return "Payment done successfully.Remaining amount to pay: " + remainingAmount;
    }
   
   
    @Override
    public void markAttendance() {
        attendance++;
        loyalityPoints += 10;
        if (attendance >= attendanceLimit()) {
            boolean isEligibleForUpgrade= true;
        }
    }
    //method to calculate discount
    public void calculateDiscount() {
        if(this.isFullPayment == true){
            this.discountAmount = this.premiumCharge*0.10;
            System.out.println("Discount applied successfully.Total discount amount is: " + this.discountAmount);
        } else {
          this.discountAmount = 5000;
          System.out.println("Discount not applied,full payment is not done yet.");
        }
    }

    // Reset PremiumMember details
    public void revertPremiumMember() {
        super.resetMember ();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.discountAmount = 5000;
        System.out.println("Premium Member is reverted to initial state successfully.");
    }
    public int attendanceLimit () {
        return 30;
    }
    //method to show common details
    @Override 
    public void display () {
        //call gymmember to show common details.
        super.display();
        
        System.out.println("Personal Trainer is: " +personalTrainer);
        System.out.println("Total paid amount: " +paidAmount);
        System.out.println("Is full payment done: " +isFullPayment);
        
        double remainingAmount = premiumCharge - this.paidAmount;
        System.out.println("Remaining amount to pay :" +remainingAmount);
        if(isFullPayment) {
            System.out.println("Discounted amount is:" + discountAmount);
        }
    }
}