package test.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YahooSearchResult {
    private WebDriver driver;
    private List<WebElement> webSearchItem = new ArrayList();
    private List<Map<String,Object>> collectResult = new ArrayList<>();
    private String selectorSearchItem = "//ol[contains(@class, 'searchCenterMiddle')]/li";
    private String selectorUrl = ".//h3/a[@href]";

    public YahooSearchResult(WebDriver driver, String search){
        this.driver = driver;
        driver.get("https://www.search.yahoo.com/search?p=" + search);
        webSearchItem = driver.findElements(By.xpath(selectorSearchItem));
        //webSearchItem.forEach(System.out::println);
    }

    public List<Map<String, Object>> getCollectResult() {
        for(WebElement result : webSearchItem){
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorUrl)).getAttribute("href")));
        }
        //collectResult.forEach(System.out::println);
        return collectResult;
    }
}
