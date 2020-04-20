package test.ui.com.google;

import test.ui.PageObject.GoogleSearchResult;
import test.ui.Steps;
import test.ui.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class TestGoogle extends WebDriverSettings {

    @org.junit.jupiter.api.Test
    public void testGoogleTaskStep(){
        GoogleSearchResult googlePage = new GoogleSearchResult(driver, "Открытие");
        List<Map<String,Object>> resultsSearch = googlePage.getCollectResult();
        Steps.checkContainsLink(driver, resultsSearch,"www.open.ru");
    }
}
