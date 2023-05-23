package ProjectEbay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ebayMainPage {
//ebay website object


    @FindBy(id = "gh-btn")
    WebElement clickBtn;
    
    /*Good Practice Should Be
    
    @FindBy(id= "gh-btn")
    WebElement seachBoxClickButton  ------> Meaningful and descriptive: Choose a name that accurately represents the purpose and 
    functionality of the interface. Interface names should be descriptive enough to convey what behavior or functionality the interface defines.
    
   
    
    
    
    
    */
    

    @FindBy(id = "gh-ac")
    WebElement search;

    @FindBy(tagName ="h1")
    WebElement amountRes;

    private WebDriver driver;


    public ebayMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchOnEbay(String prod) {
        search.click();
        search.clear();
        search.sendKeys(prod);
        clickBtn.click();


    }


    public int getAmount() {


        String pattern = amountRes.getText();
        int indx =  pattern.indexOf("+");
        pattern = pattern.substring(0,indx);
        pattern = pattern.replace(",","");
        ;        System.out.println(pattern+" Found as a result of search at ebay");
        int patternAsInt = Integer.parseInt(pattern);

        return patternAsInt;

    }


}
