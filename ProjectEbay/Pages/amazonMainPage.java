package ProjectEbay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
// for project


public class amazonMainPage {

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBarAmazon ;

    @FindBy(id = "nav-search-submit-button")
    WebElement clickButnAmazon;
    /*div[class='a-section a-spacing-small a-spacing-top-small']*/
    @FindBy(className ="a-section")
    WebElement amountResAmazon;
    private WebDriver driver;


    public amazonMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void searchOnAmazon (String product) {
        searchBarAmazon.click();
        searchBarAmazon.clear();
        searchBarAmazon.sendKeys(product);
        clickButnAmazon.click();
    }

   public int getAmountAmazon() {
        String patternAmazon = amountResAmazon.getText();
        System.out.println(patternAmazon);
        String [] stringList = patternAmazon.split(" ");
        int num = Integer.parseInt(stringList[3].replace(",",""));
        System.out.println(num+ " Found as a result of search at Amazon");

        return num;
    }
    }






