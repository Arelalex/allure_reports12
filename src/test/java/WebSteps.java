import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    TestData testData = new TestData();

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(testData.url);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        testData.search.click();
        testData.searchLine.setValue(repo);
        testData.searchLine.submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink() {
        testData.result.click();

    }

    @Step("Проверяем наличие Issues")
    public void checkIssuesTab() {
        testData.issues.shouldBe(Condition.visible);
    }
}
