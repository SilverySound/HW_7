package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;


public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String userEmail = getRandomEmail();
    String streetAddress = getRandomAddress();
    String gender = getRandomGender();
    String phone = getRandomPhone();
    String day = getRandomDay();
    String month = getRandomMonth();
    String year= getRandomYear();
    String subject = getRandomSubject();
    String hobbies = getRandomHobbies();
    String picture = getRandomPicture();
    String state = getRandomState();
    String city = getRandomCity(state);



    @Test
    void successfulRegistrationTest() {


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubjectInput(subject)
                .setHobbiesWrapper(hobbies)
                .setUploadPicture("images/" + picture)
                .setCurrentAddress(streetAddress)
                .setStateWrapper(state)
                .setCityWrapper(city)
                .clickSubmit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + " " + month +"," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minimumRequiredFields() {
        registrationPage.openPage();
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .clickSubmit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .setUserNumber(phone);


    }

    @Test
    void errorWithoutRequiredFirstName() {
        registrationPage.openPage();
        registrationPage.setFirstName("")
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubjectInput(subject)
                .setHobbiesWrapper(hobbies)
                .setUploadPicture("images/" + picture)
                .setCurrentAddress(streetAddress)
                .setStateWrapper(state)
                .setCityWrapper(city)
                .clickSubmit();

        registrationPage.checkEmptyFirstName();



    }
}