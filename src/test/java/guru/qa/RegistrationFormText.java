package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormText {

    @BeforeAll
    public static void settings() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x1200";

    }

    @Test
    void parameters() {
        String name = "Anastasia";
        String foto = "lesson_3.jpg";
        open("/automation-practice-form");

        $("#firstName").setValue("Anastasia");
        $("#lastName").setValue("Guru");
        $("#userNumber").setValue("8882882882");
        $(byText("Female")).click();
        $("#userEmail").setValue("book123@mail.ru");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label$='July 27th, 1989']").click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath(foto);
        $("#currentAddress").setValue("123 Book Street");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Student Name\t" + "Anastasia " + "Guru"),text("Mobile\t8882882882"), text("Gender\tFemale"), text("Student Email\tbook123@mail.ru"),
                text("Date of Birth\t27 July,1989"), text("Hobbies\tReading, Music"), text("Address\t123 Book Street"), text("State and City\tNCR Delhi"));

        $("#closeLargeModal").click();


    }
}


