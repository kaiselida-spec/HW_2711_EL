package utils;

import java.util.Random;

public class RandomUtils {


        private static final Random random = new Random();

        public static String randomGender() {
            String[] genders = {"Male", "Female", "Other"};
            return genders[random.nextInt(genders.length)];
        }

        public static String randomSubject() {
            String[] subjects = {"Maths", "Physics", "Biology", "English"};
            return subjects[random.nextInt(subjects.length)];
        }

        public static String randomHobby() {
            String[] hobbies = {"Sports", "Reading", "Music"};
            return hobbies[random.nextInt(hobbies.length)];
        }

        public static String randomState() {
            String[] states = {"NCR", "Uttar Pradesh", "Haryana"};
            return states[random.nextInt(states.length)];
        }

        public static String randomCityForState(String state) {
            switch (state) {
                case "NCR":
                    return "Noida";
                case "Uttar Pradesh":
                    return "Agra";
                case "Haryana":
                    return "Panipat";
                default:
                    return "Noida";
            }
        }
    }