package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class practiceform2 {

    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void parameters() {
        String First_name = "Anastasia";
        open("/automation-practice-form");
        String foto = "Lesson_2.JPG";

        $("[id=firstName]").setValue(First_name);
        $("[id=lastName]").setValue("F");
        $("[id=userEmail]").setValue("123book@me.com");
        $(byText("Female")).click();
        $("[id=userNumber]").setValue("88828828822");
        $("[id=dateOfBirthInput]").click(); // Ввод даты рождения
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label$='July 3th, 1989']").click();
        $("[id=subjectsInput]").setValue("Book Book").pressEnter();
        $(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFromClasspath(foto);
        $("[id=currentAddress]").setValue("123 Book Street");
        $("[id=state]").click();
        $(byText("NCR")).click();
        $("[id=city]").click();
        $(byText("Delhi")).click();
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(text("Student Name	" + First_name + " F"),
                text("Mobile 88828828822"), text("Picture Lesson_2.JPG"), text("Student Email 123book@me.com"),
                text("Gender Female"), text("Date of Birth 3 July,1989"), text("Subjects Book Book"),
                text("Hobbies Reading"), text("Address 123 Book Book Street"), text("State and City NCR Delhi"));

        $("#closeLargeModal").click();


    }
}

