package tests.data;

import utils.FakerUtils;
import utils.RandomUtils;

public class RegistrationTestData {

    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String phoneNumber;
    public String day;
    public String month;
    public String year;
    public String subject;
    public String hobby;
    public String picture;
    public String address;
    public String state;
    public String city;

    public RegistrationTestData() {
        firstName = FakerUtils.firstName();
        lastName = FakerUtils.lastName();
        email = FakerUtils.email();
        gender = RandomUtils.randomGender();
        phoneNumber = FakerUtils.phoneNumber();
        day = "3";
        month = "May";
        year = "1998";
        subject = RandomUtils.randomSubject();
        hobby = RandomUtils.randomHobby();
        picture = "test.jpeg";
        address = FakerUtils.address();
        state = RandomUtils.randomState();
        city = RandomUtils.randomCityForState(state);
    }
}
