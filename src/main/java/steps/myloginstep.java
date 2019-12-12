package steps;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import pages.myloginpage;

public class myloginstep extends PageObject{

	private myloginpage loginpage;
	private String baseurl;
	
	private String productdescandprice;
	
	// Syst
	
	Logger logger = Logger.getLogger(this.getClass());
	
	
	List<String> ProductDesc = new ArrayList<String>();
	List<String> ProductPrice = new ArrayList<String>();
			
	public void  openloginpage() 
	{
		logger.info("openingpage");
		//System.setProperty("webdriver.gecko.driver" , "C:\\selenium\\WebDrivers\\geckodriver.exe");
		//loginpage.openUrl("https://www.google.com/");
		loginpage.openloginpage();
	};
	
	public void searchforthetext(String arg1) 
	{
		logger.info("search text comes here");
		loginpage.searchproduct(arg1);
	}
	

	public boolean isthereaNextpage() 
	{
		// TODO Auto-generated method stub
		if (loginpage.isclicknextpage())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
    public void clicknextpage() 
    {
    	setImplicitTimeout(2, ChronoUnit.MINUTES );
    	loginpage.clicknextpage();
    	
    	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	public void getwebtabledata()
	{
		setImplicitTimeout(2, ChronoUnit.MINUTES );
		List<WebElementFacade> webElementproddesc= loginpage.getwebtableallproductdesc();
		List<WebElementFacade> webElementprodprices = loginpage.getwebtableallproductprices();

		
		for ( WebElementFacade webElementFacadedesc : webElementproddesc )
		{
			setImplicitTimeout(2, ChronoUnit.MINUTES );
			if (webElementFacadedesc.getText().isEmpty())
			{  }
			else
			{
			//logger.info(webElementFacadedesc.getText());
			ProductDesc.add(webElementFacadedesc.getText());
			
			}
		}
		
		for ( WebElementFacade webElementFacadeProdPrice : webElementprodprices )
			
		{
			setImplicitTimeout(2, ChronoUnit.MINUTES );
		//	logger.info(webElementFacadeProdPrice.getText());
			ProductPrice.add(webElementFacadeProdPrice.getText());
		}	
		
	
	}
	

	
	public String getBaseurl() 
	{
		return baseurl;
	}
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public List<String> lstprod = new ArrayList<String>();
	
	public void combinestrings() {
		
		for (int i=0 ; i < ProductDesc.size(); i++ )
		{
		productdescandprice = ProductDesc.get(i) + " \t" +  ProductPrice.get(i);
		//logger.info(productdescandprice);
		lstprod.add(productdescandprice);
		
	}
	
	
	}
	public void displaylist()
	{
	System.out.println("the total number of products " + lstprod.size());
	
	for (int z = 0 ; z< lstprod.size(); z++ )
		
	{
		System.out.println("the list is being displayed " + lstprod.get(z).toString());
	}
	}

}
