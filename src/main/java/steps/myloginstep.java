package steps;


//import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import pages.myloginpage;
import pojo.Product;

public class myloginstep extends PageObject{

	private myloginpage loginpage;
	private String baseurl;
	
	private String productdescandprice;
	
	// Syst
	
//	Logger logger = Logger.getLogger(this.getClass());
	
	public List<Product> lstproduct = new ArrayList<Product>();
	List<String> ProductDesc = new ArrayList<String>();
	List<String> ProductPrice = new ArrayList<String>();
			
	public void  openloginpage() 
	{
//		logger.info("openingpage");
		//System.setProperty("webdriver.gecko.driver" , "C:\\selenium\\WebDrivers\\geckodriver.exe");
		//loginpage.openUrl("https://www.google.com/");
		loginpage.openloginpage();
	};
	
	public void searchforthetext(String arg1) 
	{
//		logger.info("search text comes here");
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
			System.out.println("prod desc is " + ProductDesc.get(i));
			Product product = new Product();
			
			product.setProductdesc(ProductDesc.get(i));
			product.setProductprice( ProductPrice.get(i));

			
			lstproduct.add(product);
			
			productdescandprice = ProductDesc.get(i) + " \t" +  ProductPrice.get(i);
			
		//logger.info(productdescandprice);
	}
	
	}

	public void ckecklistprod()
	{
		
		System.out.println("lstproduct");
		for (int z= 0 ; z< lstproduct.size(); z++)
		{
			System.out.println(lstproduct.get(z).getProductdesc() + " "+ lstproduct.get(z).getProductprice());
		}
		
		
	}
	
	
	
	public List<String> testexcel = new ArrayList<String>();
    public File crazyfile = new File("C:\\selenium\\excel\\crazyexcel.xlsx");


	public void createandsaveexcel()  {
	
		Workbook crazyworkbook = null;
    	FileInputStream crazyfileinputstream = null;
		
	    try {
			crazyfileinputstream = new FileInputStream(crazyfile);
			crazyworkbook = new XSSFWorkbook(crazyfileinputstream);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    Sheet prodsheet = crazyworkbook.getSheetAt(0);
	    
	    
		testexcel.add("I am sushanth");
     
		testexcel.add("test");
             
	
			for (int x = 1 ; x < lstproduct.size(); x++)
			{
				
				Row row = prodsheet.createRow(x);
				
										
				Cell cell = row.createCell(0);
				cell.setCellValue(lstproduct.get(x).getProductdesc());
				
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(lstproduct.get(x).getProductprice());
				
			}
	
			
	
			
			try {
			
				FileOutputStream crazyoutputStream = null;
				crazyoutputStream = new FileOutputStream(crazyfile);
				crazyworkbook.write(crazyoutputStream);
				crazyoutputStream.close();
				crazyworkbook.close();
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
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
