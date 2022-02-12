package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
            headerTitle = $(".practice-form-wrapper"),

            firstNameInput = $x("//*[@id='firstName']"),
            lastNameInput = $x("//*[@id='lastName']"),
            userEmailInput = $x("//*[@id='userEmail']"),
            userNumberInput = $x("//*[@id='userNumber']"),

            maleGenderRadioButton = $(byText("Male")),
            femaleGenderRadioButton = $(byText("Female")),
            otherGenderRadioButton = $(byText("Other")),

            dateOfBirthInput = $x("//*[@id='dateOfBirthInput']"),

            subjectsInput = $x("//*[@id='subjectsInput']"),

            sportsCheckbox = $x("//*[@for='hobbies-checkbox-1']"),
            readingCheckbox = $x("//*[@for='hobbies-checkbox-2']"),
            musicCheckbox = $x("//*[@for='hobbies-checkbox-3']"),

            chooseFileButton = $x("//*[@id='uploadPicture']"),
            currentAddressInput = $x("//*[@id='currentAddress']"),

            stateDropdown = $x("//*[@id='react-select-3-input']"),
            cityDropdown = $x("//*[@id='react-select-4-input']"),

            submitButton = $x("//*[@id='submit']");

    String url = "/automation-practice-form";
    String title = "Student Registration Form";

    public RegistrationPage openPage() {
        open(url);
        headerTitle.shouldHave(text(title));
        return this;
    }

    public RegistrationPage setFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setUserEmail(String userEmail){
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender){
        switch (gender) {
            case "Male":
                maleGenderRadioButton.doubleClick();
                break;
            case "Female":
                femaleGenderRadioButton.doubleClick();
                break;
            case "Other":
                otherGenderRadioButton.doubleClick();
                break;
        }
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber){
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject){
        subjectsInput.setValue(subject).pressEnter();;
        return this;
    }

    public RegistrationPage setHobbies(String gender){
        switch (gender) {
            case "Sports":
                sportsCheckbox.click();
                break;
            case "Reading":
                readingCheckbox.click();
                break;
            case "Music":
                musicCheckbox.click();
                break;
        }
        return this;
    }

    public RegistrationPage setUploadFile(String classPath){
        chooseFileButton.uploadFromClasspath(classPath);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public RegistrationPage setState(String state){
        stateDropdown.setValue(state).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String city){
        cityDropdown.setValue(city).pressEnter();
        return this;
    }

    public CuccessSubmittingFormPage clickSubmitButton(){
        submitButton.click();
        return new CuccessSubmittingFormPage();
    }
}
