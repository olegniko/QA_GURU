package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CuccessSubmittingFormPage {

    String title = "Thanks for submitting the form";

    String studentName = "Student Name";
    String studentEmail = "Student Email";
    String gender = "Gender";
    String mobile = "Mobile";
    String dateOfBirth = "Date of Birth";
    String subjects = "Subjects";
    String hobbies = "Hobbies";
    String picture = "Picture";
    String address = "Address";
    String stateAndCity = "State and City";

    private final SelenideElement
            resultsTable = $(".table-responsive"),
            tableTitle = $x("//*[@id='example-modal-sizes-title-lg']");

    public CuccessSubmittingFormPage checkTableIsAppeared() {
        resultsTable.shouldBe(visible);
        return this;
    }

    public CuccessSubmittingFormPage checkTableHasCorrectTitle() {
        tableTitle.shouldHave(text(title));
        return this;
    }

    public CuccessSubmittingFormPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public CuccessSubmittingFormPage checkStudentNameForm(String value) {
        checkForm(studentName, value);
        return this;
    }

    public CuccessSubmittingFormPage checkStudentEmailForm(String value) {
        checkForm(studentEmail, value);
        return this;
    }

    public CuccessSubmittingFormPage checkGenderForm(String value) {
        checkForm(gender, value);
        return this;
    }

    public CuccessSubmittingFormPage checkMobileForm(String value) {
        checkForm(mobile, value);
        return this;
    }

    public CuccessSubmittingFormPage checkDateOfBirthForm(String value) {
        checkForm(dateOfBirth, value);
        return this;
    }

    public CuccessSubmittingFormPage checkSubjectsForm(String value) {
        checkForm(subjects, value);
        return this;
    }

    public CuccessSubmittingFormPage checkHobbiesForm(String value) {
        checkForm(hobbies, value);
        return this;
    }

    public CuccessSubmittingFormPage checkPictureForm(String value) {
        checkForm(picture, value);
        return this;
    }

    public CuccessSubmittingFormPage checkAddressForm(String value) {
        checkForm(address, value);
        return this;
    }

    public CuccessSubmittingFormPage checkStateAndCityForm(String value) {
        checkForm(stateAndCity, value);
        return this;
    }
}
