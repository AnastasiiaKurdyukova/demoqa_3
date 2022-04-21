package guru.qa.docs;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.time.LocalDate;

public class GenerateData {

    Faker faker = new Faker();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String currentAddress = faker.rickAndMorty().quote();
    public String phoneNumber = faker.number().digits(10);

    public String birthDate = formatter.format(faker.date().birthday(11, 45));
    public String[] dayMonthYear = birthDate.split(" ");
    public String dayOfBirth = dayMonthYear[0];
    public String monthOfBirth = dayMonthYear[1];
    public String yearOfBirth = dayMonthYear[2];

    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"English", "Maths", "Hindi"};
    String[] hobbies = {"Sports", "Reading", "Music"};

    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return String.valueOf(array[rnd]);
    }

    public String setRandomGenderType() {
        return getRandom(genders);
    }

    public String setRandomSubject() {
        return getRandom(subjects);
    }

    public String setRandomHobbies() {
        return getRandom(hobbies);
    }




}
