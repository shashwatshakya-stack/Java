//parent class is GymMember as abstract class
public abstract class GymMember {
    //protected attributes accessible only to respective child classes
    protected String memberId;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyalityPoints;
    protected boolean activeStatus;
    protected String markAttendance;
    //constructor method for all attributes
    public GymMember(String id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate){
      this.memberId = id;
      this.name = name;
      this.location = location;
      this.phone = phone;
      this.email = email;
      this.gender = gender;
      this.DOB = DOB;
      this.membershipStartDate = membershipStartDate;
      this.attendance = 0; //sets to 0 i.e new member with zero attendance
      this.loyalityPoints = 0; //sets to 0 i.e new member starts with zero loyalitypoints 
      this.activeStatus = false;  //sets to false by default
    }
    //getters method for all attributes 
    public String get_MemberId (){
        return memberId ;
    }
    public String get_Name () {
        return name;
    }
    public String get_Location () {
        return location;
    }
    public String getPhone () {
        return phone;
    }
    public String get_Email() {
        return this.email;
    }
        public String get_Gender () {
        return gender;
    }
    public String get_DOB () {
        return DOB;
    }
    public String get_MembershipStartDate() {
        return membershipStartDate;
    }
    public int get_markAttendance () {
        return attendance;
    }
    public double get_LoyalityPoints () {
        return loyalityPoints;
    }
    public boolean get_ActiveStatus () {
        return activeStatus;
    }
    
    //abstract method to track  attendance of member (regularmember and premiummember)
    
    public abstract void markAttendance();
     
    //this method helps in activating or renewing the membership
    public void activateMembership () {
        activeStatus = true; //sets the activestatus of membership to active
    }
    //if the membership is needed to be deactivated or paused only if it is already active
    public void deactivateMembership() {
       if (activeStatus == true) { 
           activeStatus = false; 
       }
    }
    //reset member details
    public void resetMember () {
     activeStatus = false; 
     attendance = 0; 
     loyalityPoints = 0;
    }
    //display method for all output of gymmember
    public void display () {
       System.out.println("Membership ID: " +memberId); 
       System.out.println("Name: " +name);
       System.out.println("Location: "+location);
       System.out.println("Phone number: " +phone);
       System.out.println("Email address: " +email);
       System.out.println("Gender: " +gender);
       System.out.println("Date Of Birth: "+DOB);
       System.out.println("Starting Membership Date: " +membershipStartDate);
       System.out.println("Attendance: " +attendance);
       System.out.println("Total Loyality Points Acquired: " +loyalityPoints);
       
       //checking activestatus 
       if (activeStatus = true) {
           System.out.println("Membership Status: Active");
           
       } else{
           System.out.println("Membership Status: Inactive");
       }
    }
}
    