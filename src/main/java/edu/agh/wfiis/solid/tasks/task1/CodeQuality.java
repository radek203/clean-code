package edu.agh.wfiis.solid.tasks.task1;

public enum CodeQuality {
    GOOD(10),
    EXCELLENT(75),
    FANTASTIC(100),
    BAD(-10);

    private final int points;

    CodeQuality(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

}
