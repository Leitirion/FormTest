import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @Test
    void AutomationFormTest() {
        String URL = "https://demoqa.com/automation-practice-form";
        String firstName = "firstName";
        String lastName = "lastName";
        String StudentEmail = "userEmail@gmail.com";
        String userNumber = "1234567890";
        String Day = "01";
        String Month = "May";
        String Year = "2021";

        open(URL);

        $("#firstName").setValue(firstName);

        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(StudentEmail);
        $("#userNumber").setValue(userNumber);
        $x("//input[@id=\"gender-radio-2\"][@value=\"Female\"]").doubleClick();
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        $x("//div[@class=\"react-datepicker__month\"]//div[text()=1]").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("123.PNG"));
        $("#currentAddress").setValue("Russia, Ufa.");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();


        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Student Name\"]]/td[2]").shouldBe(visible).shouldHave(text(firstName+" "+lastName));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Mobile\"]]/td[2]").shouldBe(visible).shouldHave(text(userNumber));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Student Email\"]]/td[2]").shouldBe(visible).shouldHave(text(StudentEmail));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Gender\"]]/td[2]").shouldBe(visible).shouldHave(text("Female"));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Date of Birth\"]]/td[2]").shouldBe(visible).shouldHave(text(Day+" "+Month+","+Year));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Subjects\"]]/td[2]").shouldBe(visible).shouldHave(text("History"));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Hobbies\"]]/td[2]").shouldBe(visible).shouldHave(text("Music"));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Picture\"]]/td[2]").shouldBe(visible).shouldHave(text("123.PNG"));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Address\"]]/td[2]").shouldBe(visible).shouldHave(text("Russia, Ufa."));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"State and City\"]]/td[2]").shouldBe(visible).shouldHave(text("NCR Noida"));
    }
}