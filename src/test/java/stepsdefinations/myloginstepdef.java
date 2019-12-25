package stepsdefinations;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.myloginstep;

public class myloginstepdef {

	Logger logger = Logger.getLogger(this.getClass());

	@Steps
	myloginstep loginstep;

	@Given("^user opens the home page$")
	public void user_opens_the_home_page() {
		loginstep.openloginpage();
		logger.info("In the Given");
	}

	@When("^user enters search text \"([^\"]*)\"$")
	public void user_enters_search_text(String arg1) {
		loginstep.searchforthetext(arg1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("In the When");
	}

	@When("^user clicks on next page$")
	public void user_clicks_on_next_page() {
		while (loginstep.isthereaNextpage()) {
			loginstep.clicknextpage();
			loginstep.getwebtabledata();
		}
	}


	@Then("^user gets the price list$")
	public void user_gets_the_price_list() {

		loginstep.combinestrings();
		loginstep.ckecklistprod();
		loginstep.createandsaveexcel();
		loginstep.displaylist();

	}

}
