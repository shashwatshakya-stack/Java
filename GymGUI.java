import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

// Main class for the Gym Management System GUI
public class GymGUI {
    //instance variable
    /* 
     * Label
     * textfields
     */
    private ArrayList<GymMember> memberList = new ArrayList<>();
    private JFrame guiFrame;
    private JLabel id,name,location,phone,email,gender,dob,membershipStartDate,referralsource,paidAmount,regularPrice,premiumCharge,discountAmount,removalReason,trainersName, planLabel;
    private JPanel homePanel;
    private JTextField idTF,idRTF,idPTF,nameTF,locationTF,phoneTF,emailTF,referralsourceTF,paidAmountTF,regularPriceTF,premiumChargeTF,discountAmountTF, trainersNameTF;
    private JTextArea removalReasonTA;
    private JButton addRegularMember, addPremiumMember, activateMembership, deactivateMembership, markAttendance,calculateDiscount,revertRegular,revertPremium,paydueAmount,upgradePlan,display,clear,saveToFile,readFromFile;
    private JComboBox plan,dobDay, dobMonth,dobYear, membershipStartDateday,membershipStartDatemonth,membershipStartDateyear, planComboBox;
    private JRadioButton maleRadioButton, femaleRadioButton; 
    public GymGUI(){
        guiFrame = new JFrame("24046493 Shashwat Shakya");
        guiFrame.setSize(850,850);
        guiFrame.setResizable(false);
        guiFrame.setLayout(null);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
        //homePanel
        homePanel = new JPanel();
        homePanel.setLayout(null);
        homePanel.setSize(850,850);
        Color aliceBlue = new Color(240, 248, 255); // RGB values for AliceBlue
        homePanel.setBackground(aliceBlue);//adding color

        //JLabel and JTextField
        id = new JLabel("Member Id");
        id.setBounds(50, 50, 100, 30);
        idTF = new JTextField(50);
        idTF.setBounds(180, 50, 150, 30);
        name = new JLabel("Name");
        name.setBounds(50,90,100,30);
        nameTF = new JTextField(50);
        nameTF.setBounds(180,90,150,30);
        location = new JLabel("Location");
        location.setBounds(50,130,100,30);
        locationTF = new JTextField(50);
        locationTF.setBounds(180,130,150,30);
        phone = new JLabel("Phone");
        phone.setBounds(50,170,100,30);
        phoneTF = new JTextField(50);
        phoneTF.setBounds(180,170,150,30);
        email = new JLabel("Email");
        email.setBounds(50, 210, 100, 30);
        emailTF = new JTextField(50);
        emailTF.setBounds(180,210,250,30);
        gender = new JLabel("Gender");
        gender.setBounds(50, 250, 100, 30);
        dob = new JLabel("Date of Birth");
        dob.setBounds(50, 290, 100, 30);
        membershipStartDate = new JLabel("Membership Start Date");
        membershipStartDate.setBounds(50,330,140,30);
        planLabel = new JLabel("Membership Plan");
        planLabel.setBounds(50,370,120,30);
        discountAmount = new JLabel("Discount Amount");
        discountAmount.setBounds(350, 370, 140,30);
        discountAmountTF = new JTextField();
        discountAmountTF.setBounds(480,370, 140,30);
        referralsource = new JLabel("Referral Source");
        referralsource.setBounds(50, 410, 120, 30);
        referralsourceTF = new JTextField();
        referralsourceTF.setBounds(180, 410, 150, 30);;
        paidAmount = new JLabel("Paid Amount");
        paidAmount.setBounds(50, 450, 100, 30);
        paidAmountTF = new JTextField();
        paidAmountTF.setBounds(180, 450, 150, 30);
        premiumCharge = new JLabel ("Premium Charge");
        premiumCharge.setBounds(350, 410, 120, 30);
        premiumChargeTF = new JTextField();
        premiumChargeTF.setBounds(480, 410, 150, 30);
        regularPrice = new JLabel("Regualr Price");
        regularPrice.setBounds(350, 450, 100, 30);
        regularPriceTF = new JTextField();
        regularPriceTF.setBounds(480, 450, 150, 30);
        removalReason = new JLabel("Removal Reason");
        removalReason.setBounds(50,490,120,30);
        removalReasonTA = new JTextArea();
        removalReasonTA.setBounds(180, 490, 550, 30);
        trainersName = new JLabel("Trainer's Name");
        trainersName.setBounds(50, 530, 120, 30);
        trainersNameTF = new JTextField();
        trainersNameTF.setBounds(180, 530, 150, 30);

        
        
        
        // Gender radio buttons
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setBounds(180, 250, 70, 30);
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBackground(Color.WHITE);
        femaleRadioButton.setBounds(260, 250, 80, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // ComboBoxes for date selection
        String[] years = new String[35];
        for (int i = 0; i < 35; i++) {
            years[i] = String.valueOf(1990 + i);
        }
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }

        //For DOB
        dobDay = new JComboBox<>(days);
        dobDay.setBackground(Color.WHITE);
        dobDay.setBounds(180, 290, 50, 30);
        dobMonth = new JComboBox<>(months);
        dobMonth.setBackground(Color.WHITE);
        dobMonth.setBounds(240, 290, 60, 30);
        dobYear = new JComboBox<>(years);
        dobYear.setBackground(Color.WHITE);
        dobYear.setBounds(310, 290, 70, 30);

        //ComboBox for MemberShipStartDate
        String[] Years = new String[70];
        for (int i = 0; i < 70; i++) {
            Years[i] = String.valueOf(2010 + i);
        }
        String[] Months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] Days = new String[31];
        for (int i = 0; i < 31; i++) {
            Days[i] = String.valueOf(i + 1);
        }

        //MemberShipStartDate
        membershipStartDateday = new JComboBox<>(Days);
        membershipStartDateday.setBackground(Color.WHITE);
        membershipStartDateday.setBounds(200, 330, 50, 30);
        membershipStartDatemonth = new JComboBox<>(Months);
        membershipStartDatemonth.setBackground(Color.WHITE);
        membershipStartDatemonth.setBounds(260, 330, 60, 30);
        membershipStartDateyear = new JComboBox<>(Years);
        membershipStartDateyear.setBackground(Color.WHITE);
        membershipStartDateyear.setBounds(330, 330, 70, 30);

        //ComboBox for MemberShip 
        String[] Types = {"Basic","Standard","Deluxe"};

        //Membership Types
        planComboBox = new JComboBox<>(Types);
        planComboBox.setBackground(Color.WHITE);
        planComboBox.setBounds(220, 370, 80, 30);

        
        
        // Buttons
        addRegularMember = new JButton("Add Regular Member");
        addRegularMember.setBackground(new Color(8, 129, 120));//adding color
        addRegularMember.setForeground(Color.WHITE);//adding color
        addRegularMember.setBounds(150, 580, 200, 30);
        addPremiumMember = new JButton("Add Premium Member");
        addPremiumMember.setBackground(new Color(8, 129, 120));//adding color
        addPremiumMember.setForeground(Color.WHITE);//adding color
        addPremiumMember.setBounds(370, 580, 200, 30);
        calculateDiscount = new JButton("Calulate Discount");
        calculateDiscount.setBackground(new Color(8, 129, 120));
        calculateDiscount.setForeground(Color.WHITE);//adding color
        calculateDiscount.setBounds(590, 580, 200, 30);
        activateMembership = new JButton("Activate Membership");
        activateMembership.setBackground(new Color(8, 129, 120));//adding color
        activateMembership.setForeground(Color.WHITE);//adding color
        activateMembership.setBounds(150, 630, 200, 30);
        deactivateMembership = new JButton("Deactivate Membership");
        deactivateMembership.setBackground(new Color(8, 129, 120));//adding color
        deactivateMembership.setForeground(Color.WHITE);//adding color
        deactivateMembership.setBounds(370, 630, 200, 30);
        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBackground(new Color(8, 129, 120));//adding color
        markAttendance.setForeground(Color.WHITE);
        markAttendance.setBounds(150,680,200,30);
        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBackground(new Color(8, 129, 120));//adding color
        upgradePlan.setForeground(Color.WHITE);
        upgradePlan.setBounds(370,680,200,30);
        JButton paydueAmount = new JButton("PayDueAmount");
        paydueAmount.setBackground(new Color(8, 129, 120));//adding color
        paydueAmount.setForeground(Color.WHITE);
        paydueAmount.setBounds(590,630,200,30);
        JButton revertRegular = new JButton("RevertRegular");
        revertRegular.setBackground(new Color(8, 129, 120));//adding color
        revertRegular.setForeground(Color.WHITE);
        revertRegular.setBounds(590,680,200,30);
        JButton display = new JButton("Display");
        display.setBackground(new Color(8, 129, 120));//adding color
        display.setForeground(Color.WHITE);
        display.setBounds(50, 730, 100, 30);

        JButton clear = new JButton("Clear");
        clear.setBackground(new Color(8, 129, 120));//adding color
        clear.setForeground(Color.WHITE);
        clear.setBounds(210, 730, 100, 30);

        JButton saveToFile = new JButton("Save");
        saveToFile.setBackground(new Color(8, 129, 120));//adding color
        saveToFile.setForeground(Color.WHITE);
        saveToFile.setBounds(380, 730, 100, 30);

        JButton readFromFile = new JButton("Read");
        readFromFile.setBackground(new Color(8, 129, 120));//adding color
        readFromFile.setForeground(Color.WHITE);
        readFromFile.setBounds(550, 730, 100, 30);

        JButton revertPremium = new JButton("RevertPremium");
        revertPremium.setBackground(new Color(8, 129, 120));//adding color
        revertPremium.setForeground(Color.WHITE);
        revertPremium.setBounds(680, 730, 150, 30);

        //Actionlistener
        addRegularMember.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Regualr member dont get Personal trainer
                    trainersName.setVisible(false);
                    trainersNameTF.setVisible(false);
                    //show panel fields
                    planLabel.setVisible(true);
                    regularPrice.setVisible(true);
                    regularPriceTF.setVisible(true);
                    premiumCharge.setVisible(false);
                    premiumChargeTF.setEditable(false);
                    discountAmount.setVisible(false);
                    discountAmountTF.setEditable(false);

                    String memberId = idTF.getText();
                    String name = nameTF.getText();
                    String location = locationTF.getText();
                    String phone = phoneTF.getText();
                    String email = emailTF.getText();
                    String referralsource = referralsourceTF.getText();
                    String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                    String removalReason = removalReasonTA.getText();
                    String membershipStartDate = membershipStartDateday.getSelectedItem() + "" + membershipStartDatemonth.getSelectedItem() + membershipStartDateyear.getSelectedItem();
                    String dob = dobDay.getSelectedItem() + "" + dobMonth.getSelectedItem() + "" + dobYear.getSelectedItem();
                    String paidAmount = paidAmountTF.getText();
                    String selectedPlan = (String) planComboBox.getSelectedItem();

                    //Validation for empty fields
                    if (memberId.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || referralsource.isEmpty() || paidAmount.isEmpty() || selectedPlan.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel,"Please fill all the fields." , "Incomplete Data detected!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }  
                    else if (selectedPlan.equals("Select a Plan")){
                        JOptionPane.showMessageDialog(homePanel, "Please select a plan", "Missing Plan detected!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                
                    //For duplicate Id
                    for (GymMember member : memberList) {
                        if (member.memberId.equals(memberId)) {
                            JOptionPane.showMessageDialog(homePanel, "Member ID is already registared", "Duplicate ID detected!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //If All set, Create Regular Member
                    try {
                        int id = Integer.parseInt(memberId);
                        RegularMember member = new RegularMember(memberId, name, location, phone, email,referralsource,removalReason, gender, membershipStartDate,paidAmount, selectedPlan);
                        memberList.add(member);
                        JOptionPane.showMessageDialog(homePanel, "Regular Membership is added successfully!", "Sucess", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(homePanel, "Regular Member could not be added! Plz use Number in member ID." , "Error!", JOptionPane.ERROR_MESSAGE);  
                    }
                }
            });

        addPremiumMember.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Showing trainer field in Premium member
                    trainersName.setVisible(true);
                    trainersNameTF.setVisible(true);
                    //hiding plan field for premium
                    planLabel.setVisible(true);
                    planComboBox.setVisible(false);
                    regularPrice.setVisible(false);
                    regularPriceTF.setVisible(false);
                    premiumCharge.setVisible(true);
                    premiumChargeTF.setEditable(false);
                    discountAmount.setVisible(true);
                    discountAmountTF.setEditable(false);

                    String memberId = idTF.getText();
                    String name = nameTF.getText();
                    String location = locationTF.getText();
                    String phone = phoneTF.getText();
                    String email = emailTF.getText();
                    String referralsource = referralsourceTF.getText();
                    String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                    String removalReason = removalReasonTA.getText();
                    String trainerName = trainersNameTF.getText();
                    String membershipStartDate = membershipStartDateday.getSelectedItem() + "" + membershipStartDatemonth.getSelectedItem() + membershipStartDateyear.getSelectedItem();
                    String dob = dobDay.getSelectedItem() + "" + dobMonth.getSelectedItem() + "" + dobYear.getSelectedItem();
                    String paidAmount = paidAmountTF.getText();

                    if (memberId.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || referralsource.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Fill in all the required fields." , "Incomplete Data detected", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else if (trainerName.isEmpty()){
                        JOptionPane.showMessageDialog(homePanel, "Enter the Trainer's Name.","Missing Data detected", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    //checking for duplicate IDs
                    for (GymMember member : memberList) {
                        if (member.memberId.equals(memberId)) {
                            JOptionPane.showMessageDialog(homePanel, "Member ID is already registared", "Duplicate ID detected!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //If All set for Premium
                    try {
                        int id = Integer.parseInt(memberId);
                        PremiumMember premium = new PremiumMember(memberId, name, location,phone,email,gender,dob,membershipStartDate, trainerName);
                        memberList.add(premium);
                        JOptionPane.showMessageDialog(homePanel, "Premium member is added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(homePanel, " Premium Member couldnot be added! PLz Use Number in Member ID","Error detected", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

        activateMembership.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String memberId = idTF.getText();

                    if (memberId.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter the ID.","Incomplete Data detected", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean found = false;
                    for (GymMember member : memberList) {
                        if(member. memberId.equals(memberId)) {
                            member.activateMembership();
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, "Membership is activated for:" + member.get_Name(), "Activated", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "Member with that ID is not found.", "Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

        deactivateMembership.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String id = idTF.getText().trim();

                    if(id.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Enter a Member ID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean found = false;
                    for(GymMember member : memberList) {
                        if (member.get_MemberId().equals(id)) {
                            member.deactivateMembership();
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, "Deactivated: " + member.get_Name(), "Deactivated", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "No member found with that ID.", "Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        markAttendance.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String id = idTF.getText().trim();

                    if(id.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Enter a Member ID", "Missing", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean found = false;
                    for (GymMember member : memberList) {
                        if (member.get_MemberId().equals(id)) {
                            member.markAttendance ();
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, " Attendance marked for "  +member.get_Name(), "Done", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "Member not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        //for upgrade button
        upgradePlan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Collect member ID and selected plan
                    String idText = idTF.getText().trim();
                    String selectedPlan = (String) planComboBox.getSelectedItem();

                    // Validate inputs
                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a Member ID.", "Missing ID Was Found", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (selectedPlan.equals("--Select a Plan--")) {
                        JOptionPane.showMessageDialog(homePanel, "Please select a plan.", "Missing Plan Was Found", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Upgrade plan
                    boolean found = false;
                    for (GymMember member : memberList) {
                        if (member.get_MemberId().equals(idText)) {
                            if (!(member instanceof RegularMember)) {
                                JOptionPane.showMessageDialog(homePanel, "The Member you choose is not a Regular Member.", "Invalid Member Type was detected", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (!member.get_ActiveStatus()) {
                                JOptionPane.showMessageDialog(homePanel, "The Member you choose is inactive. Cannot upgrade plan.", "Inactive Member", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            RegularMember regular = (RegularMember) member;
                            if (!regular.isEligibleForUpgrade()) {
                                JOptionPane.showMessageDialog(homePanel, "The Member you choose is not eligible for upgrade.", "Eligibility Error was detected", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            String result = regular.upgradePlan(selectedPlan);
                            regularPriceTF.setText(String.valueOf(regular.getPrice()));
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "The member ID you give was not found.", "Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        //For revert Regular member 
        revertRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idTF.getText();
                    String removalReason = removalReasonTA.getText();

                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a Member ID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (removalReason.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a removal reason.", "Missing Reason", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    boolean found = false;
                    for (GymMember member : memberList) {
                        if (member.get_MemberId().equals(id)) {
                            if (!(member instanceof RegularMember)) {
                                JOptionPane.showMessageDialog(homePanel, "Member is not a Regular Member.", "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            RegularMember regular = (RegularMember) member;
                            regular.revertRegularMember(removalReason);
                            regularPriceTF.setText(String.valueOf(regular.getPrice()));
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, "Regular Member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "No member found with that ID.", "Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        //For revert Premium Member
        revertPremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idTF.getText().trim();

                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a Member ID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean found = false;
                    for (GymMember member : memberList) {
                        if (member.get_MemberId().equals(id)) {
                            if (!(member instanceof PremiumMember)) {
                                JOptionPane.showMessageDialog(homePanel, "Member is not a Premium Member.", "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PremiumMember premium = (PremiumMember) member;
                            premium.revertPremiumMember();
                            premiumChargeTF.setText(String.valueOf(premium.premiumCharge()));
                            discountAmountTF.setText(String.valueOf(premium.getdiscountAmount()));
                            found = true;
                            JOptionPane.showMessageDialog(homePanel, "Premium Member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(homePanel, "No member found with that ID.", "Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });   
        //For Calculate Discount
        calculateDiscount.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idText = idTF.getText().trim();

                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a Member ID.", "Missing ID", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        int memberId = Integer.parseInt(idText);
                        boolean found = false;

                        for (GymMember member : memberList) {
                            if (Integer.parseInt(member.get_MemberId()) == memberId) {
                                found = true;

                                if (member instanceof PremiumMember) {
                                    PremiumMember premium = (PremiumMember) member;
                                    premium.calculateDiscount();
                                    double discount = premium.getdiscountAmount();

                                    if (discount > 0) {
                                        JOptionPane.showMessageDialog(homePanel,
                                            "Discount is available: Rs. " + discount,
                                            "Discount was Calculated", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(homePanel,
                                            "No discount was available. Full payment was not yet made.",
                                            "No Discount", JOptionPane.WARNING_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(homePanel,
                                        "Only Premium Members are eligible for discounts.",
                                        "Not a Premium Member", JOptionPane.ERROR_MESSAGE);
                                }

                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(homePanel, "No member with that ID was found.", "Not Found", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Member ID must be a valid number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        //For paydueAmount
        paydueAmount.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String memberId = idTF.getText();
                    String amountText = paidAmountTF.getText();

                    if (memberId.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter a Member ID", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (amountText.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "Please enter the amount to pay", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double amount;
                    try {
                        amount = Double.parseDouble(amountText);
                        if (amount <= 0) {
                            JOptionPane.showMessageDialog(homePanel, "Amount must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Invalid amount format", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    GymMember member = null;
                    for (GymMember m : memberList) {
                        if (m.get_MemberId().equals(id)) {
                            member = m;
                            break;
                        }
                    }

                    if (member == null) {
                        JOptionPane.showMessageDialog(homePanel, "Member not found with ID: " + memberId, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!(member instanceof PremiumMember)) {
                        JOptionPane.showMessageDialog(homePanel, "Member is not a Premium member", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    PremiumMember premium = (PremiumMember) member;
                    if (!premium.get_ActiveStatus()) {
                        JOptionPane.showMessageDialog(homePanel, "Member is inactive. Cannot process payment.", "Inactive Member", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    double remainingDue = premium.premiumCharge() - premium.getpaidAmount();
                    if (amount > remainingDue) {
                        JOptionPane.showMessageDialog(homePanel, "Payment amount exceeds remaining due amount of " + String.format("%.2f", remainingDue) + ".", "Overpayment", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String resultMessage = premium.payDueAmount(amount);
                    premiumChargeTF.setText(String.valueOf(premium.premiumCharge()));
                    if (premium.getFullpayment()) {
                        discountAmountTF.setText(String.format("%.2f", premium.getdiscountAmount()));
                    } else {
                        discountAmountTF.setText("5000");
                    }
                    paidAmountTF.setText("");
                    JOptionPane.showMessageDialog(homePanel, resultMessage, "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                }
            });

        
        //for Display button
        display.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (memberList.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "No members to show.", "Empty", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder details = new StringBuilder();
                    for (GymMember member : memberList) {
                        details.append("ID: ").append(member.get_MemberId()).append("\n");
                        details.append("Name: ").append(member.get_Name()).append("\n");
                        details.append("Type: ").append(member instanceof PremiumMember ? "Premium" : "Regular").append("\n");
                        details.append("Email: ").append(member.get_Email()).append("\n");
                        details.append("Location: ").append(member.get_Location()).append("\n");
                        details.append("Status: ").append(member.get_ActiveStatus() ? "Active" : "Inactive").append("\n\n");

                    }

                    JTextArea area = new JTextArea(details.toString());
                    area.setLineWrap(true);
                    area.setWrapStyleWord(true);
                    area.setEditable(false);

                    JScrollPane scroll = new JScrollPane(area);
                    scroll.setPreferredSize(new Dimension(500, 400));
                    JFrame displayWindow = new JFrame("All Member Details");
                    displayWindow.setSize(600, 500);
                    displayWindow.add(scroll);
                    displayWindow.setVisible(true);
                }
            });

        //for clear buttin
        clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameTF.setText("");
                    idTF.setText("");
                    locationTF.setText("");
                    phoneTF.setText("");
                    emailTF.setText("");
                    membershipStartDateday.setSelectedIndex(0);
                    membershipStartDatemonth.setSelectedIndex(0);
                    membershipStartDateyear.setSelectedIndex(0);
                    dobDay.setSelectedIndex(0);
                    dobMonth.setSelectedIndex(0);
                    dobYear.setSelectedIndex(0);
                    planComboBox.setSelectedIndex(0);
                    paidAmountTF.setText("");
                    trainersNameTF.setText("");
                    referralsourceTF.setText("");
                    removalReasonTA.setText("");
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                }
            });

        //For Save to Files
        saveToFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check if there are members to save
                    if (memberList.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "No members to save. Please add a member first.", "Empty Data", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    try (PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"))) {
                        writer.println(String.format("%-10s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s",
                                "ID", "Name", "Location", "Phone", "Email", "Start Date", "Plan", "Price", "Attendance", 
                                "Loyalty Pts", "Active", "Full Payment", "Discount", "Paid Amt"));
                        for (GymMember member : memberList) {
                            String plan = member instanceof RegularMember ? ((RegularMember) member).getPlan() : "N/A";
                            String price = member instanceof RegularMember ? String.valueOf(((RegularMember) member).getPrice()) : "N/A";
                            String fullPayment = member instanceof PremiumMember ? String.valueOf(((PremiumMember) member).getFullpayment()) : "N/A";
                            String discount = member instanceof PremiumMember ? String.valueOf(((PremiumMember) member).getdiscountAmount()) : "N/A";
                            String paidAmt = member instanceof PremiumMember ? String.valueOf(((PremiumMember) member).getpaidAmount()) : "N/A";
                            writer.println(String.format("%-10s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s",
                                    member.get_MemberId(), member.get_Name(), member.get_Location(), member.get_Email(),
                                    member.get_MembershipStartDate(), plan, price, String.valueOf(member.get_markAttendance()), String.valueOf(member.get_LoyalityPoints()),
                                    String.valueOf(member.get_ActiveStatus()), fullPayment, discount, paidAmt));
                        }
                        JOptionPane.showMessageDialog(homePanel, "Member details saved to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Error saving to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SecurityException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Permission denied: Unable to write to file: " + ex.getMessage(), "Security Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        //For Read from File
        readFromFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check if members exist or file is available
                    if (memberList.isEmpty()) {
                        JOptionPane.showMessageDialog(homePanel, "No members available. Please add a member first.", "Empty Data", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    File file = new File("MemberDetails.txt");
                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(homePanel, "No file found. Please save data first.", "File Not Found", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Read and display file contents
                    StringBuilder details = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            details.append(line).append("\n");
                        }
                        JTextArea area = new JTextArea(details.toString());
                        area.setLineWrap(true);
                        area.setWrapStyleWord(true);
                        area.setEditable(false);
                        JScrollPane scroll = new JScrollPane(area);
                        scroll.setPreferredSize(new Dimension(500, 400));
                        JFrame displayWindow = new JFrame("Member Details from File");
                        displayWindow.setSize(600, 500);
                        displayWindow.add(scroll);
                        displayWindow.setVisible(true);
                        JOptionPane.showMessageDialog(homePanel, "Member details read from file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SecurityException ex) {
                        JOptionPane.showMessageDialog(homePanel, "Permission denied: Unable to read file: " + ex.getMessage(), "Security Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        //adding components to homePanel
        homePanel.add(id);
        homePanel.add(idTF);
        homePanel.add(name);
        homePanel.add(nameTF);
        homePanel.add(location);
        homePanel.add(locationTF);
        homePanel.add(phone);
        homePanel.add(phoneTF);
        homePanel.add(email);
        homePanel.add(emailTF);
        homePanel.add(gender);
        homePanel.add(maleRadioButton);
        homePanel.add(femaleRadioButton);
        homePanel.add(dob);
        homePanel.add(dobDay);
        homePanel.add(dobMonth);
        homePanel.add(dobYear);
        homePanel.add(membershipStartDate);
        homePanel.add(membershipStartDateday);
        homePanel.add(membershipStartDatemonth);
        homePanel.add(membershipStartDateyear);
        homePanel.add(planLabel);
        homePanel.add(planComboBox);
        homePanel.add(discountAmount);
        homePanel.add(discountAmountTF);
        homePanel.add(referralsource);
        homePanel.add(referralsourceTF);
        homePanel.add(premiumCharge);
        homePanel.add(premiumChargeTF);
        homePanel.add(paidAmount);
        homePanel.add(paidAmountTF);
        homePanel.add(regularPrice);
        homePanel.add(regularPriceTF);
        homePanel.add(removalReason);
        homePanel.add(removalReasonTA);
        homePanel.add(trainersName);
        homePanel.add(trainersNameTF);
        homePanel.add(addRegularMember);
        homePanel.add(addPremiumMember);
        homePanel.add(activateMembership);
        homePanel.add(deactivateMembership);
        homePanel.add(paydueAmount);
        homePanel.add(markAttendance);
        homePanel.add(upgradePlan);
        homePanel.add(calculateDiscount);
        homePanel.add(revertRegular);
        homePanel.add(display);
        homePanel.add(clear);
        homePanel.add(saveToFile);
        homePanel.add(readFromFile);
        homePanel.add(revertPremium);

        
        //adding panels to frame
        guiFrame.add(homePanel);

        
        
        //making the frame visible
        homePanel.setVisible(true);

        guiFrame.setVisible(true);
        
    }

    public static void main(String [] args) {
        // Create an ArrayList to store GymMember objects
        ArrayList<GymMember> members = new ArrayList<GymMember>();
        new GymGUI();
    }
}