package test.ui.com.yahoo;

import org.junit.jupiter.api.Test;
import test.ui.PageObject.YahooSearchResult;
import test.ui.Steps;
import test.ui.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class TestYahoo extends WebDriverSettings {

    @Test
    public void testYandexSearch (){
        YahooSearchResult YhooPage = new YahooSearchResult(driver, "Шпажник");
        List<Map<String,Object>> resultsSearch = YhooPage.getCollectResult();
        Steps.checkContainsLink(driver, resultsSearch,"https://ru.wikipedia.org");
    }
}
