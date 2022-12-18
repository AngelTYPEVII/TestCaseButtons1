import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FirstTest {
    private String baseUrl = "https://demoqa.com/buttons";
    private SelenideElement ClickMe = Selenide.$(By.xpath("//button[@class='btn btn-primary']"));
    private SelenideElement RightClickMe = Selenide.$(By.xpath("//button[@id='rightClickBtn']"));
    private SelenideElement DoubleClickMe = Selenide.$(By.xpath("//button[@id='doubleClickBtn']"));

    public FirstTest() {
    }

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000L;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        Selenide.open(this.baseUrl);
    }

    @Test
    public void test() {
        this.step1();
        this.step2();
        this.step3();
    }

    @Step("Кнопка")
    private void step1() {
        this.ClickMe.should(new Condition[]{Condition.visible}).click();
    }

    @Step("Кнопка2")
    private void step2() {
        this.RightClickMe.should(new Condition[]{Condition.visible}).click();
    }

    @Step("Кнопка3")
    private void step3() {
        this.DoubleClickMe.should(new Condition[]{Condition.visible}).doubleClick();
    }

    @AfterEach
    public void after() {
    }
}
