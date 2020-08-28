package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeveloperPage extends BasePage {
	@FindBy(css = "div:nth-child(8) > div.page-course__card__content")
	private WebElement programcourse;
	@FindBy(css = ".cc-btn.cc-dismiss")
	private WebElement acceptcookies;
	@FindBy(css = ".btn.btn-border-white.const")
	private WebElement buynowBtn;

	public DeveloperPage(WebDriver driver) {
		super(driver);
	}
    
	//print the program overview
	public String printProgramCourse() {
		sleep(1000);
		return getText(programcourse);
	}

	//click to the "buy course" button
	public void clickToBuyCourse() {
		try {
			click(acceptcookies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(buynowBtn);
	}

	//move to new window
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}
}
