package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            UserEmailInput = $("#userEmail"),
            GenderWrapper = $("#genterWrapper"),
            UserNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            SubjectsInput = $("#subjectsInput"),
            HobbiesWrapper = $("#hobbiesWrapper"),
            UploadPicture = $("#uploadPicture"),
            CurrentAddress = $("#currentAddress"),
            StateWrapper = $("#state"),
            CityWrapper =  $("#city"),
            SubmitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


    @Step("Открыть страницу регистрационной формы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Ввести имя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввести фамилию {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email {value}")
    public RegistrationPage setUserEmail(String value) {
        UserEmailInput.setValue(value);
        return this;
    }

    @Step("Указать пол {value}")
    public RegistrationPage setGender(String value) {
        GenderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Ввести телефонный номер {value}")
    public RegistrationPage setUserNumber(String value) {
        UserNumberInput.setValue(value);
        return this;
    }

    @Step("Ввести дату рождения {day}/{month}/{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Указать предмет {value}")
    public RegistrationPage setSubjectInput(String value) {
        SubjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Указать хобби {value}")
    public RegistrationPage setHobbiesWrapper(String value) {
        HobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить картинку {value}")
    public RegistrationPage setUploadPicture(String value) {
        UploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Ввести текущий адресс {value}")
    public RegistrationPage setCurrentAddress(String value) {
        CurrentAddress.setValue(value);
        return this;
    }

    @Step("Указать штат {value}")
    public RegistrationPage setStateWrapper(String value) {
        StateWrapper.click();
        StateWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Указать город {value}")
    public RegistrationPage setCityWrapper(String value) {
        CityWrapper.click();
        CityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Нажать кнопку Submit")
    public RegistrationPage clickSubmit(){
        SubmitButton.click();
        return this;
    }

    @Step("Проверить, что введенное значение - {value} совпадает с табличным - {key}")
    public RegistrationPage checkResult(String key, String value) {
        resultComponent.checkResultForm(key,value);
        return this;
    }

    @Step("Проверить результат в случае, если не заполнено поле First Name")
    public void checkEmptyFirstName() {
        firstNameInput.shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }


}

