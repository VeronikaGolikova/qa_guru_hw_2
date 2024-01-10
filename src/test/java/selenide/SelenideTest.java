package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    void shouldHavePageSoftAssertions() {
        open("https://github.com/selenide/selenide/");
        $(byId("wiki-tab")).click();
        $(byId("wiki-pages-filter")).setValue("SoftAssertions");
        $(byId("wiki-pages-box")).$(byText("SoftAssertions")).click();
        $(".gh-header").shouldHave(text("SoftAssertions"));
    }

    @Test
    void shouldHaveJUnit5OnPageSoftAssertions() {
        open("https://github.com/selenide/selenide/wiki/SoftAssertions");
        $(byId("user-content-3-using-junit5-extend-test-class")).parent().shouldHave(text("JUnit5"));
        $(byId("user-content-3-using-junit5-extend-test-class")).parent().sibling(0).shouldHave(text("ExtendWith"));
    }
}
