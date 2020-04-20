package test.ui.ru.yandex;

import org.junit.jupiter.api.Test;
import test.ui.PageObject.YandexMarket;
import test.ui.PageObject.YandexSearchResult;
import test.ui.Steps;
import test.ui.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class TestYandex extends WebDriverSettings {

    @Test
    public void testYandexMarketTaskStep(){
        YandexMarket YandexMarketPage = new YandexMarket(driver);
        List<Map<String,Object>> resultsSearch = YandexMarketPage.getCollectResult();
        Steps.checkSearch(driver, resultsSearch,"Смартфон");

    }

    @Test
    public void testYandexSearch(){
        YandexSearchResult YandexPage = new YandexSearchResult(driver, "Шпажник");
        List<Map<String,Object>> resultsSearch = YandexPage.getCollectResult();
        Steps.checkContainsLink(driver, resultsSearch,"https://ru.wikipedia.org");
    }
}
