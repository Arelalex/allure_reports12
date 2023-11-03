import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SimpleTest {
    TestData testData = new TestData();

    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Проверка Issues в репозитории после создания Selenide Test")
    public void selenideTestCheckIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(testData.url);
        testData.search.click();
        testData.searchLine.setValue(testData.REPOSITORY);
        testData.searchLine.submit();
        testData.result.click();
        testData.issues.shouldBe(Condition.visible);
    }

    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Проверка Issues в репозитории после создания Lambda Steps Test")
    public void lambdaStepsTestCheckIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(testData.url);
        });
        step("Ищем репозиторий " + testData.REPOSITORY, () -> {
            testData.search.click();
            testData.searchLine.setValue(testData.REPOSITORY);
            testData.searchLine.submit();
        });
        step("Кликаем по ссылке репозитория " + testData.REPOSITORY, () -> {
            testData.result.click();
        });
        step("Проверяем наличие Issues", () -> {
            testData.issues.shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Проверка Issues в репозитории после создания Annotated Test")
    public void annotatedTestCheckIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(testData.REPOSITORY);
        steps.clickOnRepositoryLink();
        steps.checkIssuesTab();
    }
}
