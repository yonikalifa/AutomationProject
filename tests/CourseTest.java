package sylius.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sylius.com.pageobjects.AddressCoursePage;
import sylius.com.pageobjects.DeveloperPage;
import sylius.com.pageobjects.HomePage;
import sylius.com.pageobjects.PaymentCoursePage;
import sylius.com.pageobjects.SummaryCoursePage;

public class CourseTest extends BaseTest {

	@Test(description = "print the program course")
	public void tc01_printProgramCourse() {
		HomePage hp = new HomePage(driver);
		hp.learnCourse();

		DeveloperPage dp = new DeveloperPage(driver);
		dp.printProgramCourse();
		String message = dp.printProgramCourse();
		System.out.println(message);
		if (message.contains("Working with Resources")) {
			System.out.println("The test is succeed");
		} else {
			System.out.println("The test is failed");
		}
	}

	@Test(description = "insert wrong mail format, login should failed")
	public void tc02_fillWrongMailFormat() {
		DeveloperPage dp = new DeveloperPage(driver);
		dp.clickToBuyCourse();
		dp.moveToNewWindow();

		AddressCoursePage acp = new AddressCoursePage(driver);
		acp.fillWrongFormatMail("yonioutlook.com", "Yoni", "Niyo", "myStreet", "New York", "12345");

		String actual = acp.getMsgFailure();
		String expected = "This email is invalid.";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "print the billing address")
	public void tc03_printBillingAddress() {
		AddressCoursePage acp = new AddressCoursePage(driver);
		acp.fillAddress("yoni@outlook.com", "Yoni", "Niyo", "myStreet", "New York", "12345");

		PaymentCoursePage pcp = new PaymentCoursePage(driver);
		pcp.choosePaypalPayment();

		SummaryCoursePage scp = new SummaryCoursePage(driver);
		scp.getBillingAddressMessage();
		String message = scp.getBillingAddressMessage();
		System.out.println(message);
		if (message.contains("UNITED STATES")) {
			System.out.println("The test is succeed");
		} else {
			System.out.println("The test is failed");
		}
	}

	@Test(description = "make the process of purchase course without accept the terms and conditions, login should failed ")
	public void tc04_buyCourseWithoutTerms() {
		SummaryCoursePage scp = new SummaryCoursePage(driver);
		scp.purchaseWithoutAcceptTerms();

		String actual = scp.getMsgFailTerms();
		String expected = "Terms and conditions should be accepted";
		Assert.assertEquals(expected, actual);
	}
	
	@Test(description = "go back to the previous steps of the process")
	public void tc05_goBackDuringProcess() {
		SummaryCoursePage scp = new SummaryCoursePage(driver);
		scp.goBackToPayment();
		
		PaymentCoursePage pcp = new PaymentCoursePage(driver);
		pcp.goBackToAddress();
	}
	
	@Test(description = "make all the process of purchase course, should succeeded")
	public void tc06_buyCourseSucceed() {
		AddressCoursePage acp = new AddressCoursePage(driver);
		acp.fillAddress("yoni@outlook.com", "Yoni", "Niyo", "myStreet", "New York", "12345");

		PaymentCoursePage pcp = new PaymentCoursePage(driver);
		pcp.choosePaypalPayment();
		
		SummaryCoursePage scp = new SummaryCoursePage(driver);
		scp.completePurchaseCourse();
	}
}
