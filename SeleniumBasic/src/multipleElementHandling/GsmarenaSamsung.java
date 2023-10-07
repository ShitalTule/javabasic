package multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GsmarenaSamsung {
	
public static WebDriver setUp(String browserName,String url) {
	WebDriver driver=null;
	if(browserName.equalsIgnoreCase("Chrome")) {
		driver=new ChromeDriver();
	}
else if(browserName.equalsIgnoreCase("Firefox")) {
	driver=new FirefoxDriver();
	
}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(url);
	return driver;
}
public static void main(String[] args) {
	WebDriver driver=setUp("Chrome","https://www.gsmarena.com/samsung-phones-9.php");
	List<WebElement> divicelist=driver.findElements(By.cssSelector("#wrapper>div>#body>div>#review-body>div>ul>li"));
	System.out.println("divice list count:"+divicelist.size());
	for(int i=0;i<divicelist.size();i++) {
		System.out.println(divicelist.get(i).getText());
	}
}
}
