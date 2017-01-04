/**********

NAME:                             Chenyan Wang
STUDENT NUMBER:                    499326

ICS4U0-A, September 2016 - January 2017

THIS FILE IS PART OF THE PROGRAM:  MyHashTable

 **********/

import java.util.*;

public class MyHashTable {
	// buckets is an array of ArrayList.  Each item in an ArrayList is an EmployeeInfo object.
	private ArrayList<EmployeeInfo>[] buckets;


	// CONSTRUCTOR
	public MyHashTable(int howManyBuckets) {
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.
		// Instantiate an array to have an ArrayList as each element of the array.
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();  // Instantiate the ArrayList for bucket i.
		}
	}
        
        public ArrayList<EmployeeInfo>[] getBuckets(){
            return buckets;
        }

	public int calcBucket(int keyValue) {
		// Returns the bucket number as the integer keyValue modulo the number of buckets for the hash table.
		return(keyValue % buckets.length);
	}

	public void addEmployee(EmployeeInfo theEmployee) {
		int targetBucket = calcBucket(theEmployee.getEmployeeNumber());
		buckets[targetBucket].add(theEmployee);
	}

	//fix; need to walk through (gets) and compare then return
	public int searchEmployee (int employeeNum) {
		//return position in arrayList;
		int targetBucket = calcBucket(employeeNum);
		//walks through target bucket
		for (int i = 0; i < buckets[targetBucket].size(); i++)
		{
			EmployeeInfo tempEmployee = buckets[targetBucket].get(i);
			if (employeeNum == tempEmployee.getEmployeeNumber())
			{
				return (i); //returns position in arrayList
			}
		}
		//if there is no match, returns -1
		return (-1);
	}        

	public EmployeeInfo removeEmployee (int employeeNum) {
		int targetBucket = calcBucket(employeeNum);
		//stores location/index of employee in ArrayList
		int location = searchEmployee (employeeNum);
		if (location != -1){
			buckets[targetBucket].remove(location);
		}
		return null;
	}

	public void displayContents() {
		// Print the employee numbers for the employees stored in each bucket's ArrayList,
		// starting with bucket 0, then bucket 1, and so on.
		for (int i = 0; i < buckets.length; i++)
		{
			for (int j = 0; j < buckets[i].size(); j++)
			{
				//bucket, position, emp# and emp name
				System.out.println("Bucket #: " + i);
				System.out.println("Position #: " + j);
				System.out.println("Employee #: " + buckets[i].get(j).getEmployeeNumber());
				System.out.println("Employee Name: " + buckets[i].get(j).getFirstName() + " " + buckets[i].get(j).getLastName());

				//sex
				System.out.print("Sex: ");
				if (buckets[i].get(j).getSex() == 0)
				{
					System.out.println("Male");
				}
				else if (buckets[i].get(j).getSex() == 1)
				{
					System.out.println("Female");
				}
				else
				{
					System.out.println("Other");
				}

				//work location
				System.out.print("Work Location: ");
				if (buckets[i].get(j).getWorkLocation() == 0)
				{
					System.out.println("Mississauga");
				}
				else if (buckets[i].get(j).getWorkLocation() == 1)
				{
					System.out.println("Ottawa");
				}
				else
				{
					System.out.println("Chicago");
				}

				//deductions rate
				System.out.println("Deductions Rate: " + buckets[i].get(j).getDeductionsRate());

				//annual income
				if (buckets[i].get(j) instanceof FullTimeEmployee) {
					System.out.println("Annual Gross Income: " + ((FullTimeEmployee)buckets[i].get(j)).calcAnnualGrossIncome());

				}
				else if (buckets[i].get(j) instanceof PartTimeEmployee) {
					System.out.println("Annual Gross Income: " + ((PartTimeEmployee)buckets[i].get(j)).calcAnnualGrossIncome());
				}
			}
		}
	}
        

} // end class MyHashTable

