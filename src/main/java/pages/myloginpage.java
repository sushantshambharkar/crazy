package pages;

import net.serenitybdd.core.pages.PageObject;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

//import org.apache.log4j.Logger;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.crazimart.com/")
public class myloginpage extends PageObject {

	// Logger logger = Logger.getLogger(this.getClass());

	public void openloginpage() {
		
		open();
		
	}
//	https://www.selenium.dev/documentation/en/support_packages/working_with_cookies/
	
// https://www.selenium.dev/documentation/en/support_packages/mouse_and_keyboard_actions_in_detail/
	
	
	
	@FindBy(id = "search_query")
	WebElementFacade searchinput;

	@FindBy(xpath = "//div[@id='SearchForm']/form/input[2]")
	WebElementFacade searchinputgolink;

	@FindBy(xpath = "html[1]/body[1]/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/ul[1]/li[3]/div[2]/span[1]/span[1]")
	WebElementFacade webtableproductdetails;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/ul[1]/li[3]/div[2]/strong[1]/a[1]")
	WebElementFacade webtableproductdesc;

	@FindBy(xpath = "//a[@class='TrackLink']")
	WebElementFacade webtableproductalldesc;

	@FindBy(xpath = "//span[@class='ProductPrice']")
	WebElementFacade webtableproductallprice;

	@FindBy(xpath = "//*[@id=\"frmCompare\"]/div[2]/div[1]/div[2]/a")
	WebElementFacade clicknext;

	public void searchproduct(String arg1) {
		// TODO Auto-generated method stub
		searchinput.sendKeys(arg1);
		searchinputgolink.click();
	}

	public void clicknextpage()

	{
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if (clicknext.isDisplayed()) {
			clicknext.click();
		}
	}

	


	
	public String getwebtableproductdesc() {
		return webtableproductdesc.getTextValue();
	}

	public List<WebElementFacade> getwebtableallproductdesc() {
		setImplicitTimeout(2, ChronoUnit.SECONDS);
		waitFor(webtableproductalldesc).isDisplayed();
		// (ExpectedConditions.visibilityOfAllElements( webtableproductalldesc));
		return webtableproductalldesc.thenFindAll(By.xpath("//a[@class='TrackLink']"));

	}

	public List<WebElementFacade> getwebtableallproductprices() {
		setImplicitTimeout(30, ChronoUnit.SECONDS);
		waitFor(webtableproductallprice).isPresent();
		return webtableproductallprice.thenFindAll(By.xpath("//span[@class='ProductPrice']"));
	}

	public boolean isclicknextpage() {
		// TODO Auto-generated method stub

		if (clicknext.isVisible()) {
			return true;
		} else {
			return false;
		}
	}

}
