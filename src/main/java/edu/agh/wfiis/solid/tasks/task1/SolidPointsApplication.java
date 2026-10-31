package edu.agh.wfiis.solid.tasks.task1;

public class SolidPointsApplication {
    public static void main(String[] args) {
        User alice = new User(1, "Alice");
        User bob = new User(2, "Bob");
        Code codeToReview = new Code(1,
                """
                System.out.println("Hello world");
                """);
        PullRequest pr = new PullRequest(1, alice, codeToReview, bob);

        try {
            pr.addReview(CodeQuality.EXCELLENT);
            pr.viewPoints();

            pr.addReview(CodeQuality.BAD);
            pr.viewPoints();
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            for (int i = 0; i < 7; i++) {
                pr.addReview(CodeQuality.BAD);
                pr.viewPoints();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}