package test.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YandexSearchResult {
    private WebDriver driver;
    private List<WebElement> webSearchItem = new ArrayList();
    private List<Map<String,Object>> collectResult = new ArrayList<>();
    private String selectorSearchItem = "//li[@class = 'serp-item']";
    private String selectorUrl = ".//h2[contains(@class, organic__title-wrapper)]/a[@href]";

    public YandexSearchResult(WebDriver driver, String search){
        this.driver = driver;
        driver.get("https://www.yandex.ru/search/?text=" + search);
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
