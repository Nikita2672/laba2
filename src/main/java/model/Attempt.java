package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Attempt {
    private final Double x;
    private final BigDecimal y;
    private final BigDecimal r;
    private final String isHit;
    private final String workTime;
    private final String time;

    public Attempt(Double x, BigDecimal y, BigDecimal r, String time, String workTime, String isHit) {
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

    public BigDecimal getY() {
        return y;
    }

    public BigDecimal getR() {
        return r;
    }

    public String getIsHit() {
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
