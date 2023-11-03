import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestData {
    String url = "https://github.com/";
    String REPOSITORY = "Arelalex/files_java11";
    SelenideElement
            search = $x("//span[@class='flex-1']"),
            searchLine = $x("//input[@id='query-builder-test']"),
            result = $x("//a[@href='/Arelalex/files_java11']"),
            issues = $x("//a[@id='issues-tab']");
}
