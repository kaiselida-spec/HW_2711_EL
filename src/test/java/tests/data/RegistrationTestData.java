package tests.data;

import utils.FakerUtils;

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
        firstName = FakerUtils.getFirstName();
        lastName = FakerUtils.getLastName();
        email = FakerUtils.getEmail();
        gender = FakerUtils.getRandomGender();
        phoneNumber = FakerUtils.getPhoneNumber();
        day = FakerUtils.getRandomDay();
        month = FakerUtils.getRandomMonth();
        year = FakerUtils.getRandomYear();
        subject = FakerUtils.getRandomSubject();
        hobby = FakerUtils.getRandomHobby();
        picture = FakerUtils.getRandomPictureFileName();
        address = FakerUtils.getAddress();
        state = FakerUtils.getRandomState();
        city = FakerUtils.getRandomCity(state);
    }
}