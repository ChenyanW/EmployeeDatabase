/**********

NAME:                             Chenyan Wang
STUDENT NUMBER:                    499326

ICS4U0-A, September 2016 - January 2017

THIS FILE IS PART OF THE PROGRAM:  MyHashTable

 **********/
public class FullTimeEmployee extends EmployeeInfo{

	public double annualSalary;
        
        //constructor
	public FullTimeEmployee (int empNo, String newFirstName, String newLastName, int newSex, int newWorkLocation, double newDeductionsRate, double newAnnualSalary)
	{
		super(empNo, newFirstName, newLastName, newSex, newWorkLocation, newDeductionsRate);
		annualSalary = newAnnualSalary;
	}
        
	//Getter method for annualSalary attribute.
	public double getAnnualSalary ()
	{
		return (annualSalary);
	}

	//calculates annual income
	public double calcAnnualGrossIncome ()
	{
		return (annualSalary*(1-deductionsRate));
	}
        
        //Setter method for annualSalary attribute.
	public void setAnnualSalary (double ySalary)
	{
		annualSalary = ySalary;
	}

}