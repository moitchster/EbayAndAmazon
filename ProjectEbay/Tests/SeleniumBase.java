package ProjectEbay.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {


    public ChromeDriver  seleniumInit(String url){
        System.out.println("Starting...");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*"); // fix for chrome version 11

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(20));

        driver.get(url);
    return driver;
    }
    public void seleniumClose (ChromeDriver driver) {
        driver.close();
    }

}
