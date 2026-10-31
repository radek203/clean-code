package edu.agh.wfiis.solid.tasks.task1;

public class PullRequest {

    private final long id;
    private final User codeOwner;
    private final Code code;
    private int solidPoints = 0;
    private final User reviewer;

    public PullRequest(long id, User codeOwner, Code code, User reviewer) {
        this.id = id;
        this.codeOwner = codeOwner;
        this.code = code;
        this.reviewer = reviewer;
    }

    public void viewPoints() {
        System.out.println(codeOwner.name() + "'s PR #" + id + " code #" + code.id() + " has " + solidPoints + " points.");
    }

    public void addReview(CodeQuality codeQuality) {
        int points = codeQuality.getPoints();
        if (points < 0 && solidPoints < Math.abs(points)) {
            throw new IllegalArgumentException("Code solid points must be positive after review");
        }
        if (points < 0) {
            System.out.println(codeQuality.name() + " code reviewed by " + reviewer.name() + ". Points subtracted from " + codeOwner.name() + ".");
        } else {
            System.out.println(codeQuality.name() + " code reviewed by " + reviewer.name() + ". Points awarded to " + codeOwner.name() + ".");
        }
        solidPoints += points;
    }

}