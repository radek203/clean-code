package edu.agh.wfiis.solid.tasks.task2;

import java.util.ArrayList;
import java.util.List;

class Application {
    public static void main(String[] args) {
        Manage manage = new Manage();
        User john = new User("John Doe", "john.doe@example.com", "password123", true);
        User jane = new User("Jane", "jane.smith@example.com", "pass", false);
        User bob = new User("Bob", "bob@example.com", "qwerty", true);

        Code johnsCode = new Code(1, john);
        Code janesCode = new Code(2, jane);

        List<String> johnErrors = new ArrayList<>();
        john.validate(johnErrors);
        if (!johnErrors.isEmpty()) {
            System.out.println("Validation errors: " + johnErrors);
        }

        List<String> janeErrors = new ArrayList<>();
        jane.validate(janeErrors);
        if (!janeErrors.isEmpty()) {
            System.out.println("Validation errors: " + janeErrors);
        }

        List<String> johnsCodeComments = new ArrayList<>();
        johnsCodeComments.add("SOLID rules preserved");
        johnsCodeComments.add("Good naming");
        johnsCodeComments.add("Readable code");

        Review johnsCodeReview = manage.addReview(johnsCode, johnsCodeComments, bob, 100);
        manage.finishReview(johnsCodeReview, 10, "Great job, keep it up!");

        List<String> janesCodeComments = new ArrayList<>();
        janesCodeComments.add("LSP violated");
        janesCodeComments.add("Good naming");
        Review janesCodeReview = manage.addReview(janesCode, janesCodeComments, bob, 50);
        manage.handleCodeOwnerComments(janesCodeReview, List.of("I forgot that ISP violation should be fixed too"));
        manage.finishReview(janesCodeReview, 1, "Need some improvement!");

        Review.compare(johnsCodeReview, janesCodeReview);
    }
}