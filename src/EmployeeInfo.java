/**********

NAME:                             Chenyan Wang
STUDENT NUMBER:                    499326

ICS4U0-A, September 2016 - January 2017

THIS FILE IS PART OF THE PROGRAM:  MyHashTable

 **********/
public class EmployeeInfo
{

	// Attributes

	public int employeeNumber;
	public String firstName;
	public String lastName;
	public int sex; // 0 - male, 1- female, 2-other
	public int workLocation;// 0 - mississauga, 1- ottawa, 2-chicago
	double deductionsRate;

	// Constructor to assign passed values to attributes.
	public EmployeeInfo (int empNo, String newFirstName, String newLastName, int newSex, int newWorkLocation, double newDeductionsRate)
	{
		employeeNumber = empNo;
		firstName = newFirstName;
		lastName = newLastName;
		sex = newSex;
		workLocation = newWorkLocation;
		deductionsRate = newDeductionsRate;
	}

	// Constructor to assign default values to attributes.
	public EmployeeInfo ()
	{
		employeeNumber = -1;
		firstName = "No";
		lastName = "Name";
		sex = -1;
		workLocation = -1;
	}


	// Getter method for employeeNumber attribute.
	public int getEmployeeNumber ()
	{
		return (employeeNumber);
	}

	// Getter method for firstName attribute.
	public String getFirstName ()
	{
		return (firstName);
	}

	// Getter method for lastName attribute.
	public String getLastName ()
	{
		return (lastName);
	}

	// Getter method for sex attribute.
	public int getSex ()
	{
		return (sex);
	}

	// Getter method for workLocation attribute.
	public int getWorkLocation ()
	{
		return (workLocation);
	}

	// Getter method for deductionsRate attribute.
	public double getDeductionsRate ()
	{
		return (deductionsRate);
	}
        
        // Setter method for employeeNumber attributes.
        public void setEmployeeNumber (int empNo)
        {
            employeeNumber = empNo;
        }
        
        // Setter method for first name attributes.
        public void setFirstName (String fName)
        {
            firstName = fName;
        }
        
        // Setter method for employeeNumber attributes.
        public void setLastName (String lName)
        {
            lastName = lName;
        }
        
        // Setter method for sex attributes.
        public void setSex (int s)
        {
            sex = s;
        }
        
        // Setter method for work location attributes.
        public void setWorkLocation (int wLocation)
        {
            workLocation = wLocation;
        }
        
        // Setter method for deductions rate attributes.
        public void setDeductionsRate (double dRate)
        {
            deductionsRate = dRate;
        }

} // public class EmployeeInfo
