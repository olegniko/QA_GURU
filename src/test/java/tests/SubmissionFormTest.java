package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SubmissionFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $x("//*[@class='main-header']").shouldHave(text("Practice Form"));

        $x("//*[@id='firstName']").setValue("Aleh");
        $x("//*[@id='lastName']").setValue("Nikulenka");

        $x("//*[@id='userEmail']").setValue("email@gmail.com");

        $x("//*[@id='userNumber']").setValue("1234567890");

        $(byText("Male")).doubleClick();

        $x("//*[@id='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOptionByValue("7");
        $x("//*[@class='react-datepicker__year-select']").selectOptionByValue("1985");
        $x("//*[contains(@class,'react-datepicker__day--012')]").click();

        $x("//*[@id='subjectsInput']").setValue("English").pressEnter();

        $x("//*[@for='hobbies-checkbox-1']").click();

        $x("//*[@id='uploadPicture']").uploadFromClasspath("toUpload.png");

        $x("//*[@id='currentAddress']").setValue("Paris, Monmartr 12");

        $x("//*[@id='react-select-3-input']").setValue("Haryana").pressEnter();
        $x("//*[@id='react-select-4-input']").setValue("Panipat").pressEnter();

        $x("//*[@id='submit']").click();


        $x("//*[@class='modal-content']").shouldBe(visible);
        $x("//*[@id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));

        $x("//*[@class='table-responsive']//tbody//tr[1]//td[1]").shouldHave(text("Student name"));
        $x("//*[@class='table-responsive']//tbody//tr[1]//td[2]").shouldHave(text("Aleh Nikulenka"));

        $x("//*[@class='table-responsive']//tbody//tr[2]//td[1]").shouldHave(text("Student Email"));
        $x("//*[@class='table-responsive']//tbody//tr[2]//td[2]").shouldHave(text("email@gmail.com"));

        $x("//*[@class='table-responsive']//tbody//tr[3]//td[1]").shouldHave(text("Gender"));
        $x("//*[@class='table-responsive']//tbody//tr[3]//td[2]").shouldHave(text("Male"));

        $x("//*[@class='table-responsive']//tbody//tr[4]//td[1]").shouldHave(text("Mobile"));
        $x("//*[@class='table-responsive']//tbody//tr[4]//td[2]").shouldHave(text("1234567890"));

        $x("//*[@class='table-responsive']//tbody//tr[5]//td[1]").shouldHave(text("Date Of Birth"));
        $x("//*[@class='table-responsive']//tbody//tr[5]//td[2]").shouldHave(text("12 August,1985"));

        $x("//*[@class='table-responsive']//tbody//tr[6]//td[1]").shouldHave(text("Subjects"));
        $x("//*[@class='table-responsive']//tbody//tr[6]//td[2]").shouldHave(text("English"));

        $x("//*[@class='table-responsive']//tbody//tr[7]//td[1]").shouldHave(text("Hobbies"));
        $x("//*[@class='table-responsive']//tbody//tr[7]//td[2]").shouldHave(text("Sports"));

        $x("//*[@class='table-responsive']//tbody//tr[8]//td[1]").shouldHave(text("Picture"));
        $x("//*[@class='table-responsive']//tbody//tr[8]//td[2]").shouldHave(text("toUpload.png"));

        $x("//*[@class='table-responsive']//tbody//tr[9]//td[1]").shouldHave(text("Address"));
        $x("//*[@class='table-responsive']//tbody//tr[9]//td[2]").shouldHave(text("Paris, Monmartr 12"));

        $x("//*[@class='table-responsive']//tbody//tr[10]//td[1]").shouldHave(text("State and City"));
        $x("//*[@class='table-responsive']//tbody//tr[10]//td[2]").shouldHave(text("Haryana Panipat"));

    }
}