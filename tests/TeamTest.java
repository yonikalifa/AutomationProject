package sylius.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sylius.com.pageobjects.HomePage;
import sylius.com.pageobjects.TeamPage;

public class TeamTest extends BaseTest {

	@Test(description = "Print members names and check if contains Adam Kasperczak")
	public void tc01_printInfoTeam() {
		// Print members names and check if contains "Adam Kasperczak"
		HomePage hp = new HomePage(driver);
		hp.viewTeam();
		TeamPage tp = new TeamPage(driver);
		tp.printNames();

		boolean actual = tp.isNameExistInList("Adam Kasperczak");
		Assert.assertTrue(actual);
	}

	@Test(description = "show details about the team members when we mouse hover their pictures")
	public void tc02_hoveringToMembers() {
		// Details about the team members are displayed when we mouse hover their
		// pictures
		TeamPage tp = new TeamPage(driver);
		tp.hoveringToMembers();

		boolean actual = tp.isTermExistInList("Business");
		Assert.assertTrue(actual);

	}

}
