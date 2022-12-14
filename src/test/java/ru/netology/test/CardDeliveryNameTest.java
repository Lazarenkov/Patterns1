package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import java.time.Duration;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class CardDeliveryNameTest {

    @BeforeAll
    static void setUpAll(){
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterAll
    static void tearsDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void startBrowser() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldCreateOrderWhenAllValidDoubleFirstName() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(
                        DataGenerator.generateValidNameDoubleFirstname("RU")
                        + " "
                        + DataGenerator.generateFirstName("RU"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(1));
        $("[data-test-id='success-notification'] [class='notification__title']")
                .shouldHave(text("Успешно!"));
        $("[data-test-id='success-notification'] [class='notification__content']")
                .shouldHave(text("Встреча успешно запланирована на " + dateForTest));
    }

    @Test
    void shouldCreateOrderWhenAllValidDoubleLastname() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue
                        (DataGenerator.generateFirstName("RU")
                        + " "
                        + DataGenerator.generateValidNameDoubleLastname("RU"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(1));
        $("[data-test-id='success-notification'] [class='notification__title']")
                .shouldHave(text("Успешно!"));
        $("[data-test-id='success-notification'] [class='notification__content']")
                .shouldHave(text("Встреча успешно запланирована на " + dateForTest));
    }

    @Test
    void shouldCreateOrderWhenAllValidDoubleNameAndSurname() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue
                        (DataGenerator.generateValidNameDoubleFirstname("RU")
                        + " " +
                        DataGenerator.generateValidNameDoubleLastname("RU"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(1));
        $("[data-test-id='success-notification'] [class='notification__title']")
                .shouldHave(text("Успешно!"));
        $("[data-test-id='success-notification'] [class='notification__content']")
                .shouldHave(text("Встреча успешно запланирована на " + dateForTest));
    }

    @Test
    void shouldCreateOrderWhenValidNameWithYO() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(DataGenerator.generateValidNameWithYO("RU"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(1));
        $("[data-test-id='success-notification'] [class='notification__title']")
                .shouldHave(text("Успешно!"));
        $("[data-test-id='success-notification'] [class='notification__content']")
                .shouldHave(text("Встреча успешно запланирована на " + dateForTest));
    }

    @Test
    void shouldPrintSubWhenInvalidEnglishName() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(DataGenerator.generateValidName("EN"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Имя и Фамилия указаные неверно"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameWithChars() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(validInfo.getName() + DataGenerator.generateRandomChar());
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Имя и Фамилия указаные неверно"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameOfOneWord() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(DataGenerator.generateFirstName("RU"));
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameOfOneLetter() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(DataGenerator.generateRandomLetter());
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldPrintSubWhenInvalidEmptyName() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);

        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldPrintSubWhenInvalidSpaceName() {
        DataGenerator.UserInfo validInfo = DataGenerator.Registration.generateUser("RU");
        String dateForTest = DataGenerator.generateDate(DataGenerator.generateRandomDigit() + 5);
        $("[data-test-id='city'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='city'] [class='input__control']").setValue(validInfo.getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        $("[data-test-id='date'] [class='input__control']").setValue(dateForTest);
        $("[data-test-id='name'] [name='name']").setValue(" ");
        $("[data-test-id='phone'] [name='phone']").setValue(validInfo.getPhone());
        $("[data-test-id='agreement'] [class='checkbox__box']").click();
        $$("[type='button']").findBy(text("Запланировать")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }
}
