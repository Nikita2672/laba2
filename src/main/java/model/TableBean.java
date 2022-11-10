package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TableBean implements Serializable {

    private final List<Attempt> attempts = new ArrayList<>();

    public void addAttempt(double x, BigDecimal y, BigDecimal r, String time, String workTime, String isHit ) {
        attempts.add(new Attempt(x, y, r, time, workTime, isHit));
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableBean tableBean = (TableBean) o;
        return Objects.equals(attempts, tableBean.attempts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempts);
    }

    @Override
    public String toString() {
        return "TableBean{"
                + "attempts=" + attempts
                + '}';
    }
}
