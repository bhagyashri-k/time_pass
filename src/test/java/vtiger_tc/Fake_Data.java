package vtiger_tc;

import com.github.javafaker.Faker;

/**
 * 
 * @author HELLO
 * @description : This class is going to create fake data which is req for test execution
 *
 */
public class Fake_Data {
	Faker fake = new Faker();
	
	/**
	 * @author HELLO
	 * @description : This method is going to create a random first name
	 * @return String random first name
	 */
	public String firstName()
	{
		return fake.name().firstName();
	}
	
	
	/**
	 * @author HELLO
	 * @description : This method is going to create a random last name 
	 * @return String random last name
	 */
	public String lastName() {
		return fake.name().lastName();
	}
	
	
	/**
	 * @author HELLO
	 * @description : This method is going to create a random company name
	 * @return String random company name
	 */
	public String companyName() {
		return fake.company().name();
	}
	
	
}
