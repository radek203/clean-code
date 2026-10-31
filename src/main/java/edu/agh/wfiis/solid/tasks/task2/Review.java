package edu.agh.wfiis.solid.tasks.task2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Review {

    private final int id;
    private final Code codeToReview;
    private boolean processed;
    private final List<String> codeOwnerComments = new ArrayList<>();
    private final List<String> comments;
    private int points;

    public Review(int id, Code codeToReview, List<String> comments, User reviewer, int startPoints) {
        this.id = id;
        this.codeToReview = codeToReview;
        this.comments = List.copyOf(comments);
        this.processed = false;
        this.points = startPoints;
        System.out.println("Review for user " + codeToReview.codeOwner().name() + ", created at " + Instant.now() + " by " + reviewer.name());
    }

    public int getId() {
        return id;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void process(int score, String feedbackData) {
        if (processed) {
            throw new IllegalArgumentException("Review with ID " + id + " has already been processed. Cannot process again.");
        }
        addPoints(score, feedbackData);
        processed = true;
        System.out.println("Review #" + id + " completed for " + codeToReview.codeOwner().name() + ". Points awarded: " + score);
    }

    public void addCodeOwnerComments(List<String> list) {
        for (String data : list) {
            if (data.length() > 100) {
                System.out.println("Code owner comment '" + data + "' longer than 100 characters! Skipping it.");
                continue;
            }
            codeOwnerComments.add(data);
        }
    }

    public void addPoints(int pointsToAdd, String info) {
        if (info == null || info.isBlank()) {
            System.out.println("No additional information provided. Points not updated.");
            return;
        }
        points += pointsToAdd;
        System.out.println(info + " - New points total: " + points);
    }

    public static void compare(Review review1, Review review2) {
        if (review1 == null) {
            throw new IllegalArgumentException("review1 is null");
        }
        if (review2 == null) {
            throw new IllegalArgumentException("review2 is null");
        }

        System.out.println("Comparing " + review1.codeToReview.codeOwner().name() + "'s code with " + review2.codeToReview.codeOwner().name() + "'s code");
        System.out.println("User with better points: " + (review1.points > review2.points ? review1.codeToReview.codeOwner().name() : review2.codeToReview.codeOwner().name()));
    }
}