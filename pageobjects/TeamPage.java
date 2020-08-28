package sylius.com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamPage extends BasePage {

	@FindBy(css = "div:nth-child(2) > div:nth-child(3) > div.team-social > span.spec > a")
	private WebElement rolesLink;
	@FindBy(css = "div:nth-child(2) > div:nth-child(3)  a:nth-child(5) > i")
	private WebElement githublogo;
	@FindBy(css = ".btn.btn-green.btn-big")
	private WebElement instalink;

	public TeamPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".name")
	private List<WebElement> listname;

	// print the name of the team members
	public void printNames() {
		System.out.println("Team members names : ");
		sleep(500);
		for (WebElement el : listname) {
			System.out.println(el.getText());
		}
	}

	@FindBy(css = ".name")
	private List<WebElement> listnames;

	// check if name exist in the list of the team members
	public boolean isNameExistInList(String name) {
		for (WebElement el : listnames) {
			if (el.getText().equalsIgnoreCase(name)) {
				return true;
			} else {
			}
		}
		return false;
	}

	@FindBy(css = ".col-md-6.hidden-sm.hidden-xs .img-box ")
	private List<WebElement> list;

	// hovering with the mouse on the team members pictures
	public void hoveringToMembers() {
		for (WebElement element : list) {
			sleep(500);
			moveTo(element);
			sleep(500);
			WebElement elTxt = element.findElement(By.cssSelector("span"));
			System.out.println(elTxt.getText());
		}
	}

	@FindBy(css = ".col-md-6.hidden-sm.hidden-xs .img-box ")
	private List<WebElement> lists;

	// check if term exist in list of details about the team members
	public boolean isTermExistInList(String name) {
		for (WebElement elTxt : lists) {
			System.out.println(elTxt.getText());
			if (elTxt.getText().toLowerCase().contains(name.toLowerCase())) {
				return true;
			} else {
			}
		}
		return false;
	}

}
