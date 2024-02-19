package com.amazon.dataextract;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductInfoExtractor {


	static void login (WebDriver driver)throws Exception
	//Method for login
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//wait for a certain measure of time before throwing an exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(3000);

		// login
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		System.out.println("Login initiated");
		driver.findElement(By.id("ap_email")).sendKeys("rohinichavan4@gmail.com"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("ap_password")).sendKeys("rohini@12"+Keys.ENTER);

		//exception handled because of steal element to continue code execution
		//try catch allows to defined a block of code to be tested for exceptions(errors) while executed
		try {
			driver.findElement(By.id("signInSubmit")).click();

		}catch(Exception e)
		{

		}
		System.out.println("***Login Successful***");

		System.out.println("");
	}


	public static void main(String[] args) throws Exception {

		WebDriver driver =  new ChromeDriver();
		//login to amazon.in
		login(driver);


		//Search product details from search bar
		String product1= "Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage";
		System.out.println("after loogin "+ driver.getWindowHandle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product1);
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement element = driver.findElement(By.className("a-price-whole"));
		System.out.println("product :: "+product1+ " Price :: "+element.getText());

		//Get the cuurent window details using window handler, which helps current tabof the browse
		//get the current window so that we compare and switch to another tab
		String mainpage = driver.getWindowHandle();
		System.out.println("mainpage : "+mainpage);

		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//img[@alt='Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage, Backli...']")).click();

		//gwtWindowHandles: will return the value of the string type. we get the IDs of all windows opened by the web drivers.
		//Based on window address only you can move from one window to another window
		Set<String> allPages = driver.getWindowHandles();
		for(String page: allPages)
		{
			if(!page.equals(mainpage)) //(!) indicates not equal to
			{
				driver.switchTo().window(page);
				System.out.println("***page switched***");
				System.out.println("");
				break;
			}
		}

		System.out.println("current URL :: "+driver.getCurrentUrl());
		System.out.println("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//Product Description 
		driver.findElement(By.xpath("//span[contains(text(),'See more')]")).click();

		WebElement brandName = driver.findElement(By.xpath("//span[normalize-space()='Apple']"));
		System.out.println("Brand : "+brandName.getText());

		WebElement modelName = driver.findElement(By.xpath("//span[normalize-space()='MacBook Air']"));
		System.out.println("Model Name : "+modelName.getText());

		WebElement ScreenSize = driver.findElement(By.xpath("//span[normalize-space()='13.6']"));
		System.out.println("ScreenSize : "+ScreenSize.getText());

		WebElement color = driver.findElement(By.xpath("//span[normalize-space()='Midnight']"));
		System.out.println("color : "+color.getText());

		WebElement HarddiskSize = driver.findElement(By.xpath("//span[normalize-space()='256 GB']"));
		System.out.println("HarddiskSize : "+HarddiskSize.getText());

		WebElement CpuModel = driver.findElement(By.xpath("//span[normalize-space()='Others']"));
		System.out.println("CpuModel : "+CpuModel.getText());

		WebElement RAMMemoryInstalledSize = driver.findElement(By.xpath("//span[normalize-space()='8 GB']"));
		System.out.println("RAMMemoryInstalledSize : "+RAMMemoryInstalledSize.getText());


		WebElement OperatingSystem = driver.findElement(By.xpath("//span[normalize-space()='Mac OS']"));
		System.out.println("OperatingSystem : "+OperatingSystem.getText());

		WebElement SpecialFeature= driver.findElement(By.xpath("//span[normalize-space()='Portable, Backlit Keyboard, Thin']"));
		System.out.println("SpecialFeature : "+SpecialFeature.getText());

		WebElement GraphicsCardDescription= driver.findElement(By.xpath("//span[normalize-space()='Integrated']"));
		System.out.println("GraphicsCardDescription : "+GraphicsCardDescription.getText());

		driver.close();
		System.out.println("");

		//Product2: phone 15 pro max
		driver.switchTo().window(mainpage);
		System.out.println("***switch to main page***");
		System.out.println("current URL :: "+driver.getCurrentUrl());

		//Search  product details from search bar
		System.out.println("Product 2 search Apple iPhone 15 Pro Max (256 GB) - Black Titanium");
		System.out.println("");

		String product2= "Apple iPhone 15 Pro Max (256 GB) - Black Titanium";
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product2);
		driver.findElement(By.id("nav-search-submit-button")).click();

		WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-price-whole'][normalize-space()='1,48,900']"));
		System.out.println("product2 :: "+product2+ " Price :: "+element1.getText());

		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='Apple iPhone 15 Pro Max (256 GB) - Black Titanium']")).click();

		allPages = null;
		allPages = driver.getWindowHandles();
		for(String page: allPages)
		{
			if(!page.equals(mainpage)) //(!) indicates not equal to
			{
				driver.switchTo().window(page);
				System.out.println("***page switched***");
				System.out.println("");
				break;
			}
		}

		System.out.println("current URL :: "+driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//Product Description 
		WebElement brand = driver.findElement(By.xpath("//span[normalize-space()='Apple']"));
		System.out.println("Brand : "+brand.getText());

		WebElement modelName1 = driver.findElement(By.xpath("//span[@class='a-size-base po-break-word'][normalize-space()='iPhone 15 Pro Max']"));
		System.out.println("Model Name1 : "+modelName1.getText());

		WebElement NetworkServiceProvider= driver.findElement(By.xpath("//span[normalize-space()='Unlocked for All Carriers']"));
		System.out.println("NetworkServiceProvider : "+NetworkServiceProvider.getText());

		WebElement OperatingSystem1	= driver.findElement(By.xpath("//span[normalize-space()='iOS']"));
		System.out.println("OperatingSystem1 : "+OperatingSystem1.getText());

		WebElement CellularTechnology= driver.findElement(By.xpath("//span[normalize-space()='5G']"));
		System.out.println("CellularTechnology : "+CellularTechnology.getText());

		driver.close();
		System.out.println("");

		//Product3: rtgvh
		driver.switchTo().window(mainpage);
		System.out.println("***switch to main page***");
		System.out.println("current URL :: "+driver.getCurrentUrl());
		System.out.println("");

		//Search  product details from search bar
		System.out.println("Product3 rtgvh");
		System.out.println("");

		String product3= "Product3 rtgvh";
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product3);
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("No results for Product3 rtgvh.");

		//driver.close();
        //this is a test


	}


}
