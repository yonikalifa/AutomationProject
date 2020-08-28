package sylius.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sylius.com.pageobjects.CustomersPage;
import sylius.com.pageobjects.DashboardPage;
import sylius.com.pageobjects.HomePage;
import sylius.com.pageobjects.LoginAdminPage;

public class AdminTest extends BaseTest {

	@Test(description = "use incorrect login information")
	public void tc01_loginFailure() {
		// Login with other credentials
		HomePage hp = new HomePage(driver);
		hp.viewAdmin();
		hp.moveToNewWindow();

		LoginAdminPage adp = new LoginAdminPage(driver);
		adp.LoginAdmin("Yoni", "1234");

		String actual = adp.getMessageFail();
		String expected = "Bad credentials.";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "insert the credentials that indicated by the web site")
	public void tc02_loginSucceed() {
		// Login with the credentials indicated by the web site
		LoginAdminPage adp = new LoginAdminPage(driver);
		adp.LoginAdmin("sylius@example.com", "sylius");

		DashboardPage dp = new DashboardPage(driver);
		Assert.assertTrue(dp.isDashboardPage());
	}

	// @Test(description = "delete one of new customers")
	public void tc03_deleteNewCustomer() {
		// Delete new customers
		DashboardPage dashp = new DashboardPage(driver);
		dashp.showNewCustomer();

		CustomersPage custp = new CustomersPage(driver);
		custp.deleteNewCustomer();

		String actual = custp.getMessageDeleted();
		String expected = "Shop user has been successfully deleted.";
		custp.goBackToDashboard();
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "logout of the Dashboard page")
	public void tc04_logout() {
		// Logout of the Dashboard page
		DashboardPage dashp = new DashboardPage(driver);
		dashp.logout();

		LoginAdminPage ap = new LoginAdminPage(driver);
		Assert.assertTrue(ap.isAdminPage());

	}

}
