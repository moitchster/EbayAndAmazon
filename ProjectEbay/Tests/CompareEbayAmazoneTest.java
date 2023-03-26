package ProjectEbay.Tests;

import ProjectEbay.Pages.ebayMainPage;
import ProjectEbay.Pages.amazonMainPage;
import Selenuim.SeleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareEbayAmazoneTest {
    public static void main(String[] args) throws InterruptedException {
        SeleniumBase base = new SeleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com/");
        ebayMainPage ebayMain = new ebayMainPage(driver);
        ebayMain.searchOnEbay("grapic card");
        int amountEbay = ebayMain.getAmount();
        System.out.println(amountEbay);
        driver = base.seleniumInit("https://www.amazon.com/");
        amazonMainPage page= new amazonMainPage(driver);
        page.searchOnAmazon("graphic card");
        int amountAmazon = page.getAmountAmazon();

        if(amountAmazon > amountEbay){
            System.out.println("Amazon has more results");
        }else if(amountAmazon < amountEbay){
            System.out.println("Ebay has more results");
        }else {
            System.out.println("they have the same results");
        }


        base.seleniumClose(driver);

    }
}
