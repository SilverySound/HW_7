package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static Faker faker = new Faker(new Locale("en"));

    public static String getRandomFirstName()
    {
        return faker.name().firstName();
    }

    public static String getRandomLastName()
    {
        return faker.name().lastName();
    }

    public static String getRandomEmail()
    {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender()
    {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomPhone()
    {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomAddress()
    {
        return faker.address().streetAddress();
    }

        public static String getRandomMonth()
    {
        String[] month = {"May","June","July","October"};
        return faker.options().option(month);
    }

    public static String getRandomSubject(){
        String[] subjects = {"Physics", "Chemistry","Math","Computer Science", "Commerce", "Economics"};
        return faker.options().option(subjects);
    }

    public static String getRandomHobbies()
    {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public static String getRandomState()
    {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {
        if (state == "NCR") {
            String cities[] = {"Delhi", "Gurgaon", "Noida"};
            return faker.options().option(cities);
        } else if (state == "Uttar Pradesh") {
            String cities[] = {"Agra", "Lucknow", "Merrut"};
            return faker.options().option(cities);
        } else if (state == "Haryana") {
            String cities[] = {"Karnal", "Panipat"};
            return faker.options().option(cities);
        } else if (state == "Rajasthan") {
            String cities[] = {"Jaipur", "Jaiselmer"};
            return faker.options().option(cities);
        }
    }



}