package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	@FindBy(css = "tr:nth-child(2) > td:nth-child(3) > div")
	private WebElement showcustBtn;
	@FindBy(css = "tr:nth-child(2) > td:nth-child(4)")
	private WebElement showordBtn;
	@FindBy(css = "div:nth-child(7) > span")
	private WebElement adminBtn;
	@FindBy(css = "#sylius-logout-button")
	private WebElement logoutBtn;
	@FindBy(css = ".sub.header")
	private WebElement titleLabel;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	// check if test succeed : if over to the Dashboard page
	public boolean isDashboardPage() {
		if (getText(titleLabel).contains("your store")) {
			return true;
		}
		return false;
	}

	// delete one of the new customers
	public void showNewCustomer() {
		click(showcustBtn);
	}

	// delete one of the new orders
	public void showNewOrder() {
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");
		sleep(2000);
		click(showordBtn);
	}

	// logout from the Dashboard page
	public void logout() {
		moveTo(adminBtn);
		sleep(500);
		click(logoutBtn);
	}

}
