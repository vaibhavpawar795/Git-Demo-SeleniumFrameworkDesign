import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//predicate, consumer
		Predicate<URI> uriPredicate =uri ->  uri.getHost().contains("httpbin.org");
						
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");		
	}   
}