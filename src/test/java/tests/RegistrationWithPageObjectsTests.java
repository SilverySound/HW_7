package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .setUserEmail("Anna@Ivanova.com")
                .setGender("Other")
                .setUserNumber("3752911122")
                .setDateOfBirth("2", "May", "1985")
                .setSubjectInput("English")
                .setHobbiesWrapper("Reading")
                .setUploadPicture("images/1.png")
                .setCurrentAddress("Street 1")
                .setStateWrapper("NCR")
                .setCityWrapper("Delhi")
                .clickSubmit()

                .checkResult("Student Name", "Anna Ivanova")
                .checkResult("Student Email", "Anna@Ivanova.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "3752911122")
                .checkResult("Date of Birth", "2 May,1985")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Address", "Street 1")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minimumRequiredFields() {
        registrationPage.openPage();
        registrationPage.setFirstName("Anna")
                .setLastName("Ivanova")
                .setGender("Other")
                .setUserNumber("3752911122")
                .clickSubmit()

                .checkResult("Student Name", "Anna Ivanova")
                .checkResult("Gender", "Other")
                .setUserNumber("3752911122");


    }

    @Test
    void errorWithoutRequiredFirstName() {
        registrationPage.openPage();
        registrationPage.setFirstName("")
                .setLastName("Ivanova")
                .setUserEmail("Anna@Ivanova.com")
                .setGender("Other")
                .setUserNumber("3752911122")
                .setDateOfBirth("2", "May", "1985")
                .setSubjectInput("English")
                .setHobbiesWrapper("Reading")
                .setUploadPicture("images/1.png")
                .setCurrentAddress("Street 1")
                .setStateWrapper("NCR")
                .setCityWrapper("Delhi")
                .clickSubmit()

                .checkEmptyFirstName();

    }
}