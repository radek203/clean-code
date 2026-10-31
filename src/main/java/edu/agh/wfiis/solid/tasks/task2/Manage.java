package edu.agh.wfiis.solid.tasks.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manage {

    private final Map<Integer, Review> reviews = new HashMap<>();

    public Review addReview(Code codeToReview, List<String> comments, User reviewer, int startPoints) {
        if (comments == null || comments.isEmpty()) {
            throw new IllegalArgumentException("comments is null or empty");
        }

        Review review = new Review(reviews.size() + 1, codeToReview, comments, reviewer, startPoints);
        reviews.put(review.getId(), review);

        return review;
    }

    public void handleCodeOwnerComments(Review review, List<String> comments) {
        if (review == null) {
            throw new IllegalArgumentException("review is null");
        }
        if (comments == null || comments.isEmpty()) {
            throw new IllegalArgumentException("comments is null or empty");
        }

        review.addCodeOwnerComments(comments);
    }

    public void finishReview(Review review, int score, String feedbackData) {
        if (review == null) {
            throw new IllegalArgumentException("review is null");
        }

        if (review.isProcessed()) {
            System.out.println("Review has already been processed. No points will be awarded.");
            return;
        }

        review.process(score, feedbackData);
    }
}