package test.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static test.CustomUtils.stopSec;

public class YandexMarket {

    private WebDriver driver;
    private List<WebElement> SearchPhone = new ArrayList();
    private List<Map<String,Object>> collectResult = new ArrayList<>();

    private String selectorInput = "//input[@id = 'header-search']";
    private String selectorButton = "//button[@type = 'submit']";
    private String selectorSearch = "//a[contains(@href, 'mobilnye-telefony')]";
    private String selectorSearchPhone = "//div[contains(@class, 'n-snippet-cell2__header')]//a";

    public  YandexMarket(WebDriver driver){

        this.driver = driver;
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath(selectorInput)).click();
        driver.findElement(By.xpath(selectorInput)).sendKeys("Apple");
        driver.findElement(By.xpath(selectorButton)).click();
        driver.findElement(By.xpath(selectorSearch)).click();
        stopSec(3);
        this.SearchPhone = driver.findElements(By.xpath(selectorSearchPhone));
    }
    public List<Map<String, Object>> getCollectResult(){
        for(WebElement result : SearchPhone){
            collectResult.add(Map.of(
                    "Search_block", result,
                    "Text", result.findElement(By.xpath(selectorSearchPhone)).getAttribute("text")));
        }
        //collectResult.forEach(System.out::println);
        return collectResult;
    }
}
