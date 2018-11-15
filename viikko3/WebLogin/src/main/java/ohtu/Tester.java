package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        loginSuccess();
        loginNotSuccess();
        registerSuccess();
        registerThenLogoutSuccess();
    }

    private static void loginSuccess() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);

        driver.quit();
    }

    private static void loginNotSuccess() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaUnbelieveble");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);

        driver.quit();
    }

    private static void registerSuccess() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(1);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);

        driver.quit();
    }

    private static void registerThenLogoutSuccess() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(1);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);
        element.submit();

        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(1);
        WebElement element1 = driver.findElement(By.linkText("continue to application mainpage"));
        element1.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(1);
        WebElement element2 = driver.findElement(By.linkText("logout"));
        element2.click();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        sleep(1);
        
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
