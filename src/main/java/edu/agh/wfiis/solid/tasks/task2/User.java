package edu.agh.wfiis.solid.tasks.task2;

import java.util.List;
import java.util.Set;

public record User(String name, String email, String password, boolean active) {

    private static final Set<Character> INVALID_CHARACTERS = Set.of('!', '@', '#', '$', '%', '^', '&', '*');

    public void validate(List<String> err) {
        if (name.isEmpty()) {
            err.add("User key cannot be empty.");
        }
        if (!email.contains("@")) {
            err.add("Client email is invalid.");
        }
        if (password.length() < 6) {
            err.add("Pass must be at least 6 characters long.");
        }
        for (char c : password.toCharArray()) {
            if (INVALID_CHARACTERS.contains(c)) {
                err.add("Password contains an invalid character: " + c);
            }
        }
        if (!active) {
            err.add("Customer is currently inactive.");
        }
    }

}
