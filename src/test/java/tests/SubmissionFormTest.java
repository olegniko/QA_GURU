package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CuccessSubmittingFormPage;
import pages.RegistrationPage;

public class SubmissionFormTest {

    RegistrationPage registrationPage = new RegistrationPage();
    CuccessSubmittingFormPage cuccessSubmittingFormPage = new CuccessSubmittingFormPage();

    String firstName = "Aleh";
    String lastName = "Nikulenka";
    String fullName = firstName + " " + lastName;
    String userEmail = "email@gmail.com";
    String userNumber = "1234567890";
    String gender = "Male";
    String monthOfBirth = "7";
    String yearOfBirth = "1985";
    String dayOfBirth = "012";
    String dateOfBirth = "12 August,1985";
    String subject = "English";
    String hobby = "Sports";
    String classPath = "toUpload.png";
    String currentAddress = "Paris, Monmartr 12";
    String state = "Haryana";
    String city = "Panipat";
    String stateAndCity = state + " " + city;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage
                 .openPage()
                 .setFirstName(firstName)
                 .setLastName(lastName)
                 .setUserEmail(userEmail)
                 .setUserNumber(userNumber)
                 .setGender(gender)
                 .setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth)
                 .setSubjects(subject)
                 .setHobbies(hobby)
                 .setUploadFile(classPath)
                 .setCurrentAddress(currentAddress)
                 .setState(state)
                 .setCity(city)
                 .clickSubmitButton();

        cuccessSubmittingFormPage
                .checkTableIsAppeared()
                .checkTableHasCorrectTitle()
                .checkStudentNameForm(fullName)
                .checkStudentEmailForm(userEmail)
                .checkMobileForm(userNumber)
                .checkGenderForm(gender)
                .checkDateOfBirthForm(dateOfBirth)
                .checkSubjectsForm(subject)
                .checkHobbiesForm(hobby)
                .checkPictureForm(classPath)
                .checkAddressForm(currentAddress)
                .checkStateAndCityForm(stateAndCity);
    }
}