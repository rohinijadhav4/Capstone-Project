import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductInfoExtractor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver =  new ChromeDriver();
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
		
		//exception handled because of steal element to cntinuecode execution
		//try catch allows to defined a block of code to be tested for exceptions(errors) while executed
		try {
			driver.findElement(By.id("signInSubmit")).click();
			
		}catch(Exception e)
		{
			
		}
		System.out.println("Login Successful");
		
		
		String product1= "macbook air";
		//searchbox
		System.out.println("after loogin "+ driver.getWindowHandle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product1);
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement element = driver.findElement(By.className("a-price-whole"));
		System.out.println("product :: "+product1+ " Price :: "+element.getText());
		
		//Get the cuurent window details using window handler, which helps current tabof the browse
		//get the current window so that we compare and switch to another tab
		String mainpage = driver.getWindowHandle();
		System.out.println("mainpage : "+mainpage);
		
		driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Apple 2023 MacBook Air Laptop with M2 chip: 38.91cm (15.3 inch) Liquid Retina Display, 8GB RAM 512GB SSD St...']")).click();
		//gwtWindowHandles: will return the value of the string type. we get the IDs of all windows opened by the web drivers.
		Set<String> allPages = driver.getWindowHandles();
		for(String page: allPages)
		{
			if(!page.equals(mainpage)) //(!) indicates not equal to
			{
				driver.switchTo().window(page);
				System.out.println("page switched");
				break;
			}
		}
		
		System.out.println("current URL :: "+driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//span[contains(text(),'See more')]")).click();
		
		WebElement brandName = driver.findElement(By.xpath("//span[normalize-space()='Apple']"));
		System.out.println("Brand : "+brandName.getText());
		
		WebElement modelName = driver.findElement(By.xpath("//span[normalize-space()='MacBook Air']"));
		System.out.println("Model Name : "+modelName.getText());
		
		WebElement ScreenSize = driver.findElement(By.xpath("//span[normalize-space()='15.3 Inches']"));
		System.out.println("ScreenSize : "+ScreenSize.getText());
		
		WebElement color = driver.findElement(By.xpath("//span[@class='a-size-base po-break-word'][normalize-space()='Midnight']"));
		System.out.println("color : "+color.getText());
		
		WebElement HarddiskSize = driver.findElement(By.xpath("//span[@class='a-size-base po-break-word'][normalize-space()='512 GB']"));
		System.out.println("HarddiskSize : "+HarddiskSize.getText());
		
		WebElement CpuModel = driver.findElement(By.xpath("//span[normalize-space()='None']"));
		System.out.println("CpuModel : "+CpuModel.getText());
		
		WebElement RAMMemoryInstalledSize = driver.findElement(By.xpath("//span[normalize-space()='8 GB']"));
		System.out.println("RAMMemoryInstalledSize : "+RAMMemoryInstalledSize.getText());
		

		WebElement OperatingSystem = driver.findElement(By.xpath("//span[normalize-space()='Mac OS']"));
		System.out.println("OperatingSystem : "+OperatingSystem.getText());
		
		WebElement SpecialFeature= driver.findElement(By.xpath("//span[@class='a-truncate-cut'][contains(text(),'Apple M2 Chip, Liquid Retina display with True Ton')]"));
		System.out.println("SpecialFeature : "+SpecialFeature.getText());
		
		WebElement GraphicsCardDescription= driver.findElement(By.xpath("//span[normalize-space()='Integrated']"));
		System.out.println("GraphicsCardDescription : "+GraphicsCardDescription.getText());
		
		//to do
		//String product2= "iphone";
		
		
	}

}
