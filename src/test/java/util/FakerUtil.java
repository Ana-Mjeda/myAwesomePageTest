package util;

import com.github.javafaker.Faker;

public class FakerUtil {

    private final static Faker FAKER = new Faker();

    public static String getPassword() {
        return FAKER.internet().password();
    }

    public static String getEmail(){
        return FAKER.internet().safeEmailAddress();
    }

    public static String getName(){
        return FAKER.name().fullName();
    }
    public static String getPhoneNumber(){
        return FAKER.phoneNumber().cellPhone();
    }

    public static String getCountry(){
        return FAKER.country().name();
    }

    public static String getTwitter(){
        return "https://twitter.com/" + FAKER.name().username().toLowerCase();
    }

    public static String getGitHub(){
        return "https://github.com/" + FAKER.name().username().toLowerCase();    }
}
