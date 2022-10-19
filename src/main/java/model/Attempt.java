package model;

import java.util.Objects;

public class Attempt {
    private final Double x;
    private final Double y;
    private final Double r;
    private final Boolean isHit;
    private final String workTime;
    private final String time;

    public Attempt(Double x, Double y, Double r, String time, String workTime, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
        this.workTime = workTime;
        this.time = time;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public Boolean getIsHit() {
        return isHit;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attempt attempt = (Attempt) o;
        return Objects.equals(x, attempt.x) && Objects.equals(y, attempt.y) && Objects.equals(r, attempt.r) && Objects.equals(isHit, attempt.isHit) && Objects.equals(workTime, attempt.workTime) && Objects.equals(time, attempt.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, isHit, workTime, time);
    }
}
