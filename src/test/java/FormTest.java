import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;




public class FormTest {

    public void elementShouldHaveText(String row, String value){
        $x("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"%s\"]]/td[2]".formatted(row)).shouldBe(visible).shouldHave(text(value));
    }
    @Test
    void AutomationFormTest() {
        String URL = "https://demoqa.com/automation-practice-form";
        String firstName = "firstName";
        String lastName = "lastName";
        String StudentEmail = "userEmail@gmail.com";
        String userNumber = "1234567890";
        String Day = "01";
        String Month = "April";
        String Year = "2001";

        open(URL);

        $("#firstName").setValue(firstName);

        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(StudentEmail);
        $("#userNumber").setValue(userNumber);
        $x("//input[@id=\"gender-radio-2\"][@value=\"Female\"]").doubleClick();
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        $x("//select[@class=\"react-datepicker__year-select\"]//option[@value=\"2001\"][text()=\"2001\"]").click();
        $x("//select[@class=\"react-datepicker__month-select\"]//option[@value=\"3\"][text()=\"April\"]").click();
        $x("//div[@class=\"react-datepicker__month\"]//div[text()=1]").click();

        $("#subjectsInput").setValue("History").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("resources/TestPicture.PNG"));
        $("#currentAddress").setValue("Russia, Ufa.");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();

        elementShouldHaveText("Student Name",firstName+" "+lastName);
        elementShouldHaveText("Mobile",userNumber);
        elementShouldHaveText("Student Email",StudentEmail);
        elementShouldHaveText("Gender","Female");
        elementShouldHaveText("Date of Birth",Day+" "+Month+","+Year);
        elementShouldHaveText("Subjects","History");
        elementShouldHaveText("Hobbies","Music");
        elementShouldHaveText("Picture","TestPicture.PNG");
        elementShouldHaveText("Address","Russia, Ufa.");
        elementShouldHaveText("State and City","NCR Noida");

    }
}