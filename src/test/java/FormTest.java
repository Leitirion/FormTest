import org.junit.jupiter.api.Test;

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

        $("#firstName").setValue(firstName).pressEnter();

        $("#lastName").setValue(lastName).pressEnter();

        $("#userEmail").setValue(StudentEmail).pressEnter();

        $x("//input[@id=\"gender-radio-2\"][@value=\"Female\"]").doubleClick();
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        $x("//div[@class=\"react-datepicker__month\"]//div[text()=1]").click();
        $("#userNumber").setValue(userNumber).pressEnter();


       // $x("//input[@id=\"dateOfBirthInput\"]").setValue(Day+" "+Month+" "+Year);

        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Student Name\"]]/td[2]").shouldBe(visible).shouldHave(text(firstName+" "+lastName));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Mobile\"]]/td[2]").shouldBe(visible).shouldHave(text(userNumber));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Student Email\"]]/td[2]").shouldBe(visible).shouldHave(text(StudentEmail));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Gender\"]]/td[2]").shouldBe(visible).shouldHave(text("Female"));
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"Date of Birth\"]]/td[2]").shouldBe(visible).shouldHave(text(Day+" "+Month+","+Year));
        //div[@class="modal-content"]//tbody//tr[.//td[1][text()="Gender"]]/td[2]
    }
}