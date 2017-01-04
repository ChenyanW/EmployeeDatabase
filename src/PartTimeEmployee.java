/**********

NAME:                             Chenyan Wang
STUDENT NUMBER:                    499326

ICS4U0-A, September 2016 - January 2017

THIS FILE IS PART OF THE PROGRAM:  MyHashTable

 **********/
public class PartTimeEmployee extends EmployeeInfo{

	public double hourlyWage;
	public double hoursPerWeek;
	public double weeksPerYear;

	public PartTimeEmployee (int empNo, String newFirstName, String newLastName, int newSex, int newWorkLocation, double newDeductionsRate, double newHourlyWage, double newHoursPerWeek, double newWeeksPerYear)
	{
		super(empNo, newFirstName, newLastName, newSex, newWorkLocation, newDeductionsRate);
		hourlyWage = newHourlyWage;
		hoursPerWeek = newHoursPerWeek;
		weeksPerYear = newWeeksPerYear;
	}
	//Getter method for hourlyWage attribute.
	public double getHourlyWage ()
	{
		return (hourlyWage);
	}
	//Getter method for hoursPerWeek attribute.
	public double getHoursPerWeek ()
	{
		return (hoursPerWeek);
	}
	//Getter method for weeksPerYear attribute.
	public double getWeeksPerYear ()
	{
		return (weeksPerYear);
	}

	//calculates annual income
	public double calcAnnualGrossIncome ()
	{
		return ((hourlyWage*hoursPerWeek*weeksPerYear)*(1-deductionsRate));
	}
        
        //Setter method for hourly wage attribute.
        public void setHourlyWage (double hWage)
	{
		hourlyWage = hWage;
	}
	//Setter method for hours per week attribute.
	public void setHoursPerWeek (double hPerWeek)
	{
		hoursPerWeek = hPerWeek;
	}
	//Setter method for weeks per year attribute.
	public void setWeeksPerYear (double wPerYear)
	{
		weeksPerYear = wPerYear;
	}

}


