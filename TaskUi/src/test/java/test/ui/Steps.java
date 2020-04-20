package test.ui;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import test.CustomUtils;

import java.util.List;
import java.util.Map;

public class Steps {
    @Step("Проверка наличия ссылки {link}")
    public static void checkContainsLink(WebDriver driver, List<Map<String,Object>> resultsSearch, String link){
        Assert.assertTrue("Ссылки на wikipedia нет",
                resultsSearch.stream().anyMatch(x -> x.get("URL").toString().contains(link))
        );
        CustomUtils.getScreen(driver);
    }

    @Step("Проверка выборки на наличие только смартвонов")
    public static void checkSearch(WebDriver driver, List<Map<String,Object>> resultsSearch, String Text){
        Assert.assertTrue("В выборке не только телефоны",
                resultsSearch.stream().allMatch(x -> x.get("Text").toString().contains(Text))
        );
        CustomUtils.getScreen(driver);
    }
}
