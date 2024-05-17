package tests;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;


public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String userEmail = getRandomEmail();
    String streetAddress = getRandomAddress();
    String gender = getRandomGender();
    String phone = getRandomPhone();
    String month = getRandomMonth();
    String subject = getRandomSubject();
    String hobbies = getRandomHobbies();
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
                .setUploadPicture("images/1.png")
                .setCurrentAddress(streetAddress)
                .setStateWrapper(state)
                .setCityWrapper(city)
                .clickSubmit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + " " + month +" " + year)
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

                .checkResult("Student Name", firstName + lastName)
                .checkResult("Gender", gender)
                .setUserNumber(phone);


    }

    @Test
    void errorWithoutRequiredFirstName() {
        registrationPage.openPage();
        registrationPage.setFirstName()
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubjectInput(subject)
                .setHobbiesWrapper(hobbies)
                .setUploadPicture("images/1.png")
                .setCurrentAddress(streetAddress)
                .setStateWrapper(state)
                .setCityWrapper(city)
                .clickSubmit()

                .checkEmptyFirstName();

    }
}