package sylius.com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sylius.com.pageobjects.HomePage;

public class ScheduleTest extends BaseTest {

	@Test(description = "insert all fields, login should succeeded")
	// Login to "Schedule a call"
	public void tc01_loginSucceed() {
		HomePage schedulepage = new HomePage(driver);
		schedulepage.scheduleaCall("Yoni", "0500000000","yoni@outlook.com","Hello Sylius!");

		String actual = schedulepage.getMessage();
		String expected = "Thank you for your message. It has been sent.";
		Assert.assertEquals(expected, actual);
	}

	@Test(dataProvider = "getData",description = "insert all fields, with wrong mail format - in this test i used DataProvider, "
			+ "which means the test will run multiples times with different data-sets - login should failed")
	// Login to "Schedule a call" with wrong mail format
	public void tc02_loginWrongFormatMail(String name, String phone, String email, String message) {
		HomePage schewrongmail = new HomePage(driver);
		schewrongmail.scheduleaCall(name, phone, email, message);

		String actual = schewrongmail.getMsgFailureMail();
		String expected = "The e-mail address entered is invalid.";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "insert all fields, with wrong phone format, login should failed")
	// Login to "Schedule a call" with wrong phone format
	public void tc03_loginWrongFormatPhone() {
		HomePage schewrongphone = new HomePage(driver);
		schewrongphone.scheduleaCall("Yoni", "My Phone", "yoni@outlook.com", "Hello Sylius");

		String actual = schewrongphone.getMsgFailurePhone();
		String expected = "The telephone number is invalid.";
		Assert.assertEquals(expected, actual);
	}
	
	@Test(description = "leave name field empty, login should failed")
	// Login to "Schedule a call" with missing field
	public void tc04_loginMissingField() {
		HomePage schedulefailure = new HomePage(driver);
		schedulefailure.scheduleMissingField("0500000000", "yoni@outlook.com", "Hello Sylius");

		String actual = schedulefailure.getMessageFailure();
		String expected = "One or more fields have an error. Please check and try again.";
		Assert.assertEquals(expected, actual);
	}

@DataProvider
public Object[][] getData(){
	Object[][] myData= {
			{"Yoni", "0500000000","MyEmail","Hello Sylius!"},			
			{"Yoni", "0500000000","yonioutlook.com","Hello Sylius!"},
			{"Yoni", "0500000000","Yoni.com","Hello Sylius!"},
			{"Yoni", "0500000000","Yoni148","Hello Sylius!"}
};
return myData;
}
}