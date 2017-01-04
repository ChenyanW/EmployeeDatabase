
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author 499326
 */
public class FrameEdit extends javax.swing.JFrame {
    
    int error = 0; // 0 if no error, 1+ if error
    
    //stores currently selected employee number in currrentEmpNum
    String currentEmpNum = FrameDisplay.getSelectedEmployeeNumber();
    //stores bucket and position in list of employee in variables "currentBucket" and "position"
    int currentBucket = FrameMain.getEmployeeHashTable().calcBucket(Integer.parseInt(currentEmpNum));
    int position = FrameMain.getEmployeeHashTable().searchEmployee(Integer.parseInt(currentEmpNum));
    //stores the employee of interest in variable currentEmployee
    EmployeeInfo currentEmployee = FrameMain.getEmployeeHashTable().getBuckets()[currentBucket].get(position);
    
    /**
     * Creates new form FrameEdit
     */
    public FrameEdit() {
        initComponents();
        
        //popup appears if user tries to close window
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int selectedOption = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to close the window?",
                        "EXIT",
                        JOptionPane.YES_NO_OPTION);
                //if user clicks yes, program closes
                if (selectedOption == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                }
            }
        });
        
        //displays given information in edit frame
        //employee number
        textFieldEditEmployeeNumber.setText(Integer.toString(currentEmployee.getEmployeeNumber()));
        //first name
        textFieldEditFirstName.setText(currentEmployee.getFirstName());
        //last name
        textFieldEditLastName.setText(currentEmployee.getLastName());
        //sex
        if (currentEmployee.getSex()==0){//male
            radioEditSexMale.setSelected(true);
        }
        else if (currentEmployee.getSex()==1){//female
            radioEditSexFemale.setSelected(true);
        }
        else if (currentEmployee.getSex()==2){//other
            radioEditSexOther.setSelected(true);
        }
        else{//error
            error++;
        }
        //work location
        if (currentEmployee.getWorkLocation()==0){//mississauga
            radioEditWorkLocationMississauga.setSelected(true);
        }
        else if (currentEmployee.getWorkLocation()==1){//ottawa
            radioEditWorkLocationOttawa.setSelected(true);
        }
        else if (currentEmployee.getWorkLocation()==2){//chicago
            radioEditWorkLocationChicago.setSelected(true);
        }
        else{//error
            error++;
        }
        //deductions rate
        textFieldEditDeductionsRate.setText(Double.toString(currentEmployee.getDeductionsRate()));
        //employee type
        if (currentEmployee instanceof PartTimeEmployee) {
            panelEditPartTime.setVisible(true);
            panelEditFullTime.setVisible(false);
            //employee type
            radioEditPartTime.setSelected(true);
            //hourly wage
            textFieldEditHourlyWage.setText(Double.toString(((PartTimeEmployee)currentEmployee).getHourlyWage()));
            //hours per week
            textFieldEditHoursPerWeek.setText(Double.toString(((PartTimeEmployee)currentEmployee).getHoursPerWeek()));
            //weeks per year
            textFieldEditWeeksPerYear.setText(Double.toString(((PartTimeEmployee)currentEmployee).getWeeksPerYear()));
            
        }
        else if (currentEmployee instanceof FullTimeEmployee) {
            panelEditFullTime.setVisible(true);
            panelEditPartTime.setVisible(false);
            
            //employee type
            radioEditFullTime.setSelected(true);
            //annual salary
            textFieldEditAnnualSalary.setText(Double.toString(((FullTimeEmployee)currentEmployee).getAnnualSalary()));
        }
        
        //if there is no error
        if (error ==0){
            panelEditMessage.setVisible(false);//sets error message to be invisible
        }
        else{
            //if there is an error
            labelEditMessage.setText("Error loading information.");
            panelEditMessage.setVisible(false);//sets error message to be visible
        }
    }
    
    //initializing variables
    private int employeeType = -1; //0 = employee is part time, 1 = full time, -1 = unknown
    private String firstName;
    private String lastName;
    private int employeeNumber;
    private int sex = -1; // 0 - male, 1- female, 2-other
    private int workLocation = -1;// 0 - mississauga, 1- ottawa, 2-chicago
    private double deductionsRate;
    private double hourlyWage;
    private double hoursPerWeek;
    private double weeksPerYear;
    private double annualSalary;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSex = new javax.swing.ButtonGroup();
        buttonGroupWorkLocation = new javax.swing.ButtonGroup();
        buttonGroupEmployeeType = new javax.swing.ButtonGroup();
        textFieldEditFirstName = new javax.swing.JTextField();
        labelEditFirstName = new javax.swing.JLabel();
        textFieldEditLastName = new javax.swing.JTextField();
        labelEditLastName = new javax.swing.JLabel();
        textFieldEditEmployeeNumber = new javax.swing.JTextField();
        labelEditEmployeeNumber = new javax.swing.JLabel();
        panelEditFullTime = new javax.swing.JPanel();
        labelEditFullTime = new javax.swing.JLabel();
        textFieldEditAnnualSalary = new javax.swing.JTextField();
        labelEditAnnualSalary = new javax.swing.JLabel();
        radioEditSexFemale = new javax.swing.JRadioButton();
        radioEditSexMale = new javax.swing.JRadioButton();
        radioEditSexOther = new javax.swing.JRadioButton();
        labelEditSex = new javax.swing.JLabel();
        buttonEditSave = new javax.swing.JButton();
        radioEditWorkLocationMississauga = new javax.swing.JRadioButton();
        buttonEditExit = new javax.swing.JButton();
        radioEditWorkLocationOttawa = new javax.swing.JRadioButton();
        panelEditMessage = new javax.swing.JPanel();
        labelEditMessage = new javax.swing.JLabel();
        radioEditWorkLocationChicago = new javax.swing.JRadioButton();
        labelEditWorkLocation = new javax.swing.JLabel();
        radioEditPartTime = new javax.swing.JRadioButton();
        radioEditFullTime = new javax.swing.JRadioButton();
        labelEditEmployeeType = new javax.swing.JLabel();
        textFieldEditDeductionsRate = new javax.swing.JTextField();
        labelEditDeductionsRate = new javax.swing.JLabel();
        panelEditPartTime = new javax.swing.JPanel();
        labeEditlPartTime = new javax.swing.JLabel();
        textFieldEditHourlyWage = new javax.swing.JTextField();
        labeEditHourlyWage = new javax.swing.JLabel();
        textFieldEditHoursPerWeek = new javax.swing.JTextField();
        labelEditHoursPerWeek = new javax.swing.JLabel();
        textFieldEditWeeksPerYear = new javax.swing.JTextField();
        labelEditWeeksPerYear = new javax.swing.JLabel();
        labelEditTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        textFieldEditFirstName.setText("First Name");

        labelEditFirstName.setText("First Name");

        textFieldEditLastName.setText("Last Name");

        labelEditLastName.setText("Last Name");

        textFieldEditEmployeeNumber.setText("Employee Number");

        labelEditEmployeeNumber.setText("Employee Number");

        panelEditFullTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelEditFullTime.setText("Full Time Employee Info");

        textFieldEditAnnualSalary.setText("#.##");

        labelEditAnnualSalary.setText("Annual Salary");

        javax.swing.GroupLayout panelEditFullTimeLayout = new javax.swing.GroupLayout(panelEditFullTime);
        panelEditFullTime.setLayout(panelEditFullTimeLayout);
        panelEditFullTimeLayout.setHorizontalGroup(
            panelEditFullTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditFullTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditFullTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditFullTime)
                    .addComponent(labelEditAnnualSalary)
                    .addComponent(textFieldEditAnnualSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEditFullTimeLayout.setVerticalGroup(
            panelEditFullTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditFullTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditFullTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEditAnnualSalary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldEditAnnualSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        buttonGroupSex.add(radioEditSexFemale);
        radioEditSexFemale.setText("Female");
        radioEditSexFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditSexFemaleActionPerformed(evt);
            }
        });

        buttonGroupSex.add(radioEditSexMale);
        radioEditSexMale.setText("Male");
        radioEditSexMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditSexMaleActionPerformed(evt);
            }
        });

        buttonGroupSex.add(radioEditSexOther);
        radioEditSexOther.setText("Other");
        radioEditSexOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditSexOtherActionPerformed(evt);
            }
        });

        labelEditSex.setText("Sex");

        buttonEditSave.setText("Save Edit and Exit");
        buttonEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditSaveActionPerformed(evt);
            }
        });

        buttonGroupWorkLocation.add(radioEditWorkLocationMississauga);
        radioEditWorkLocationMississauga.setText("Mississauga");
        radioEditWorkLocationMississauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditWorkLocationMississaugaActionPerformed(evt);
            }
        });

        buttonEditExit.setText("Exit");
        buttonEditExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditExitActionPerformed(evt);
            }
        });

        buttonGroupWorkLocation.add(radioEditWorkLocationOttawa);
        radioEditWorkLocationOttawa.setText("Ottawa");
        radioEditWorkLocationOttawa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditWorkLocationOttawaActionPerformed(evt);
            }
        });

        panelEditMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelEditMessage.setText("Error: Invalid input(s).");

        javax.swing.GroupLayout panelEditMessageLayout = new javax.swing.GroupLayout(panelEditMessage);
        panelEditMessage.setLayout(panelEditMessageLayout);
        panelEditMessageLayout.setHorizontalGroup(
            panelEditMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEditMessageLayout.setVerticalGroup(
            panelEditMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditMessage)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        buttonGroupWorkLocation.add(radioEditWorkLocationChicago);
        radioEditWorkLocationChicago.setText("Chicago");
        radioEditWorkLocationChicago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditWorkLocationChicagoActionPerformed(evt);
            }
        });

        labelEditWorkLocation.setText("Work Location");

        buttonGroupEmployeeType.add(radioEditPartTime);
        radioEditPartTime.setText("Part Time Employee");
        radioEditPartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditPartTimeActionPerformed(evt);
            }
        });

        buttonGroupEmployeeType.add(radioEditFullTime);
        radioEditFullTime.setText("Full Time Employee");
        radioEditFullTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditFullTimeActionPerformed(evt);
            }
        });

        labelEditEmployeeType.setText("Employee Type");

        textFieldEditDeductionsRate.setText("#.##");

        labelEditDeductionsRate.setText("Deductions Rate");

        panelEditPartTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labeEditlPartTime.setText("Part Time Employee Info");

        textFieldEditHourlyWage.setText("##.##");

        labeEditHourlyWage.setText("Hourly Wage ($)");

        textFieldEditHoursPerWeek.setText("##");

        labelEditHoursPerWeek.setText("Hours Per Week");

        textFieldEditWeeksPerYear.setText("##");

        labelEditWeeksPerYear.setText("Weeks Per Year");

        javax.swing.GroupLayout panelEditPartTimeLayout = new javax.swing.GroupLayout(panelEditPartTime);
        panelEditPartTime.setLayout(panelEditPartTimeLayout);
        panelEditPartTimeLayout.setHorizontalGroup(
            panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditPartTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditPartTimeLayout.createSequentialGroup()
                        .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeEditHourlyWage)
                            .addGroup(panelEditPartTimeLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textFieldEditHourlyWage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEditHoursPerWeek)
                            .addComponent(textFieldEditHoursPerWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEditWeeksPerYear)
                            .addComponent(textFieldEditWeeksPerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labeEditlPartTime))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelEditPartTimeLayout.setVerticalGroup(
            panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditPartTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeEditlPartTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeEditHourlyWage)
                    .addComponent(labelEditHoursPerWeek)
                    .addComponent(labelEditWeeksPerYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditPartTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditHoursPerWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEditHourlyWage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEditWeeksPerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        labelEditTitle.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        labelEditTitle.setText("Edit an Employee");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(labelEditTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldEditFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelEditFirstName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldEditLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelEditLastName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEditEmployeeNumber)
                                    .addComponent(textFieldEditEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioEditSexFemale)
                                    .addComponent(radioEditSexOther)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(labelEditSex))
                                    .addComponent(radioEditSexMale))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioEditWorkLocationMississauga)
                                            .addComponent(labelEditWorkLocation)
                                            .addComponent(radioEditWorkLocationOttawa))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelEditEmployeeType)
                                                    .addComponent(radioEditPartTime))
                                                .addGap(14, 14, 14))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(radioEditFullTime)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldEditDeductionsRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelEditDeductionsRate)))
                                    .addComponent(radioEditWorkLocationChicago)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelEditPartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelEditMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonEditSave)
                                .addGap(10, 10, 10)
                                .addComponent(buttonEditExit))
                            .addComponent(panelEditFullTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditTitle)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditLastName)
                    .addComponent(labelEditEmployeeNumber)
                    .addComponent(labelEditFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEditFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEditLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEditEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditWorkLocation)
                    .addComponent(labelEditSex)
                    .addComponent(labelEditEmployeeType)
                    .addComponent(labelEditDeductionsRate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEditSexFemale)
                    .addComponent(radioEditWorkLocationMississauga)
                    .addComponent(radioEditPartTime)
                    .addComponent(textFieldEditDeductionsRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEditSexMale)
                    .addComponent(radioEditWorkLocationOttawa)
                    .addComponent(radioEditFullTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEditSexOther)
                    .addComponent(radioEditWorkLocationChicago))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEditPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(panelEditMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEditFullTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEditExit)
                            .addComponent(buttonEditSave))))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void radioEditSexFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditSexFemaleActionPerformed
        //if sex is female
        sex = 1;
    }//GEN-LAST:event_radioEditSexFemaleActionPerformed
    
    private void radioEditSexMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditSexMaleActionPerformed
        //if sex is male
        sex = 0;
    }//GEN-LAST:event_radioEditSexMaleActionPerformed
    
    private void radioEditSexOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditSexOtherActionPerformed
        //if sex is other
        sex = 2;
    }//GEN-LAST:event_radioEditSexOtherActionPerformed
    
    private void buttonEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditSaveActionPerformed
        //puts information from textfields into variables while error checking
        int error = 0;//stores whether there is an error, 0 = no error, 1+ = error
        
        if (textFieldEditFirstName.getText() != null && textFieldEditLastName.getText() != null){
            firstName = textFieldEditFirstName.getText();
            lastName = textFieldEditLastName.getText();
        }
        else {//first name or last name input is null, error message is displayed
            panelEditMessage.setVisible(true);
        }
        if (FrameMain.isInteger(textFieldEditEmployeeNumber.getText()) == true && textFieldEditEmployeeNumber.getText() != null){
            employeeNumber = Integer.parseInt(textFieldEditEmployeeNumber.getText());}
        else {//employee number input is not an integer, error message is displayed
            error++;
        }
        if (FrameMain.isDouble(textFieldEditDeductionsRate.getText())==true && textFieldEditDeductionsRate.getText() != null && (Double.parseDouble(textFieldEditDeductionsRate.getText()) >= 0) && (Double.parseDouble(textFieldEditDeductionsRate.getText())<= 1)){
            deductionsRate = Double.parseDouble(textFieldEditDeductionsRate.getText());
        }
        else{//employee deductions rate is not a real number, nonexistent, or is not within the range between 0-1
            error++;
        }
        
        if (sex == -1 || workLocation == -1){//no inputs for either sex or work location
            error++;
        }
        
        //If there is no error, edit frame will close after saving the data into the tree
        if (employeeType == 0) {//part time
            if (FrameMain.isDouble(textFieldEditHourlyWage.getText())== true
                    && FrameMain.isDouble(textFieldEditHoursPerWeek.getText()) == true
                    && FrameMain.isDouble(textFieldEditWeeksPerYear.getText()) == true
                    && textFieldEditHourlyWage.getText() != null
                    && textFieldEditHoursPerWeek.getText() != null
                    && textFieldEditWeeksPerYear.getText() != null
                    && (Double.parseDouble(textFieldEditHourlyWage.getText()) >= 0)
                    && (Double.parseDouble(textFieldEditHoursPerWeek.getText()) >= 0)
                    && (Double.parseDouble(textFieldEditWeeksPerYear.getText()) >= 0)
                    ){
                hourlyWage = Double.parseDouble(textFieldEditHourlyWage.getText());
                hoursPerWeek = Double.parseDouble(textFieldEditHoursPerWeek.getText());
                weeksPerYear = Double.parseDouble(textFieldEditWeeksPerYear.getText());}
            else {// one of the inputs of hourly wage, hours per week and weeks per year is NOT a real value or is empty or is negative
                error++;
            }
            
            //makes employee, closes edit frame and opens display frame if there is no error
            if (error == 0){//there is no error
                //creates new parttime employee
                PartTimeEmployee newPartTimeEmployee = new PartTimeEmployee (employeeNumber, firstName, lastName, sex, workLocation, deductionsRate, hourlyWage, hoursPerWeek, weeksPerYear);
                //removes old employee from table
                FrameMain.getEmployeeHashTable().removeEmployee(currentEmployee.getEmployeeNumber());
                //adds new parttime employee to table
                FrameMain.getEmployeeHashTable().addEmployee(newPartTimeEmployee);
                
                dispose();
                new FrameDisplay().setVisible(true);}
            else {//there is an error
                panelEditMessage.setVisible(true);
            }
        }
        else if (employeeType == 1) {//full time
            if (FrameMain.isDouble(textFieldEditAnnualSalary.getText()) == true
                    && textFieldEditAnnualSalary.getText() != null
                    && Double.parseDouble(textFieldEditAnnualSalary.getText()) >= 0
                    ){
                annualSalary = Double.parseDouble(textFieldEditAnnualSalary.getText());}
            else {//input for annualSalary is not a real value, is empty, or is less than 0, error message is displayed
                panelEditMessage.setVisible(true);
                error++;
            }
            //makes employee, closes edit frame and opens display frame if there is no error
            if (error == 0){//there is no error
                //creates new fulltime employee
                FullTimeEmployee newFullTimeEmployee = new FullTimeEmployee (employeeNumber, firstName, lastName, sex, workLocation, deductionsRate, annualSalary);
                //removes old employee from table
                FrameMain.getEmployeeHashTable().removeEmployee(currentEmployee.getEmployeeNumber());
                //adds new fulltime employee to table
                FrameMain.getEmployeeHashTable().addEmployee(newFullTimeEmployee);
                
                dispose();
                new FrameDisplay().setVisible(true);}
            else {//there is an error
                panelEditMessage.setVisible(true);
            }
            
        }
        else {//undeclared, error message displayed
            panelEditMessage.setVisible(true);
            error++;
        }
        
    }//GEN-LAST:event_buttonEditSaveActionPerformed
    
    private void radioEditWorkLocationMississaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditWorkLocationMississaugaActionPerformed
        //if work location is missisauga
        workLocation = 0;
    }//GEN-LAST:event_radioEditWorkLocationMississaugaActionPerformed
    
    private void buttonEditExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditExitActionPerformed
        //closes edit frame without saving
        new FrameDisplay().setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonEditExitActionPerformed
    
    private void radioEditWorkLocationOttawaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditWorkLocationOttawaActionPerformed
        //if work location is ottawa
        workLocation = 1;
    }//GEN-LAST:event_radioEditWorkLocationOttawaActionPerformed
    
    private void radioEditWorkLocationChicagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditWorkLocationChicagoActionPerformed
        //if work location is chicago
        workLocation = 2;
    }//GEN-LAST:event_radioEditWorkLocationChicagoActionPerformed
    
    private void radioEditPartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditPartTimeActionPerformed
        //sets visibility of part time panel true and full time false
        panelEditFullTime.setVisible(false);
        panelEditPartTime.setVisible(true);
        employeeType = 0;
    }//GEN-LAST:event_radioEditPartTimeActionPerformed
    
    private void radioEditFullTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditFullTimeActionPerformed
        //sets visibility of full time panel true and part time false
        panelEditPartTime.setVisible(false);
        panelEditFullTime.setVisible(true);
        employeeType = 1;
    }//GEN-LAST:event_radioEditFullTimeActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEdit().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditExit;
    private javax.swing.JButton buttonEditSave;
    private javax.swing.ButtonGroup buttonGroupEmployeeType;
    private javax.swing.ButtonGroup buttonGroupSex;
    private javax.swing.ButtonGroup buttonGroupWorkLocation;
    private javax.swing.JLabel labeEditHourlyWage;
    private javax.swing.JLabel labeEditlPartTime;
    private javax.swing.JLabel labelEditAnnualSalary;
    private javax.swing.JLabel labelEditDeductionsRate;
    private javax.swing.JLabel labelEditEmployeeNumber;
    private javax.swing.JLabel labelEditEmployeeType;
    private javax.swing.JLabel labelEditFirstName;
    private javax.swing.JLabel labelEditFullTime;
    private javax.swing.JLabel labelEditHoursPerWeek;
    private javax.swing.JLabel labelEditLastName;
    private javax.swing.JLabel labelEditMessage;
    private javax.swing.JLabel labelEditSex;
    private javax.swing.JLabel labelEditTitle;
    private javax.swing.JLabel labelEditWeeksPerYear;
    private javax.swing.JLabel labelEditWorkLocation;
    private javax.swing.JPanel panelEditFullTime;
    private javax.swing.JPanel panelEditMessage;
    private javax.swing.JPanel panelEditPartTime;
    private javax.swing.JRadioButton radioEditFullTime;
    private javax.swing.JRadioButton radioEditPartTime;
    private javax.swing.JRadioButton radioEditSexFemale;
    private javax.swing.JRadioButton radioEditSexMale;
    private javax.swing.JRadioButton radioEditSexOther;
    private javax.swing.JRadioButton radioEditWorkLocationChicago;
    private javax.swing.JRadioButton radioEditWorkLocationMississauga;
    private javax.swing.JRadioButton radioEditWorkLocationOttawa;
    private javax.swing.JTextField textFieldEditAnnualSalary;
    private javax.swing.JTextField textFieldEditDeductionsRate;
    private javax.swing.JTextField textFieldEditEmployeeNumber;
    private javax.swing.JTextField textFieldEditFirstName;
    private javax.swing.JTextField textFieldEditHourlyWage;
    private javax.swing.JTextField textFieldEditHoursPerWeek;
    private javax.swing.JTextField textFieldEditLastName;
    private javax.swing.JTextField textFieldEditWeeksPerYear;
    // End of variables declaration//GEN-END:variables
}
