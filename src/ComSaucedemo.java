/**
 *1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComSaucedemo {

    static String browser = "firefox"; // choose browser
    static WebDriver driver; // declare globally

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        String baseURL = "https://www.saucedemo.com/"; // set base url
        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver

        System.out.println(driver.getTitle()); // print tile
        System.out.println(driver.getCurrentUrl()); // print current url
        System.out.println(driver.getPageSource()); // print page source

        WebElement email = driver.findElement(By.id("user-name"));    //find email field and enter email by ID
        email.sendKeys("standard_user");   // type into box, action

        WebElement password = driver.findElement(By.id("password"));       //find password field and enter password by ID
        password.sendKeys("secret_sauce");    // type into box, action

        WebElement loginLink = driver.findElement(By.id("login-button")); // hover to login button
        loginLink.click(); // click on link

        System.out.println(driver.getCurrentUrl()); // print current url

        driver.navigate().to(baseURL); // tell driver to navigate to base url
        driver.navigate().refresh(); // refresh url

       driver.quit();  // close browser
    }

}
