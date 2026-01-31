
package tests;

import utils.FakerUtils;


public class TestData {

    FakerUtils fakerUtils = new FakerUtils();
    String firstName = fakerUtils.getFirstName(),
            lastName = fakerUtils.getLastName(),
            fullName = firstName + " " + lastName,
            email = fakerUtils.getEmail(),
            gender = fakerUtils.getRandomGender(),
            phoneNumber = fakerUtils.getPhoneNumber(),
            day = fakerUtils.getRandomDay(),
            month = fakerUtils.getRandomMonth(),
            year = fakerUtils.getRandomYear(),
            dateBirth = day + " " + month + "," + year,
            picture = fakerUtils.getRandomPictureFileName(),
            fullAddress = fakerUtils.getAddress(),
            subjects = fakerUtils.getRandomSubject(),
            hobbies = fakerUtils.getRandomHobby(),
            state = fakerUtils.getRandomState(),
            city = fakerUtils.getRandomCity(state);
}
