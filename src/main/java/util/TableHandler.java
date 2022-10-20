package util;

import model.TableBean;

public class TableHandler {

    private TableHandler() {
    }

    public static String makeDataForTable(TableBean tableBean) {
        StringBuilder stringBuilder = new StringBuilder();
        if (tableBean != null)
            for (int i = 0; i < tableBean.getAttempts().size(); i++) {
                stringBuilder.append("%");
                stringBuilder.append(tableBean.getAttempts().get(i).getX());
                stringBuilder.append("*").append(tableBean.getAttempts().get(i).getY());
                stringBuilder.append("*").append(tableBean.getAttempts().get(i).getR());
                stringBuilder.append("*").append(tableBean.getAttempts().get(i).getTime());
                stringBuilder.append("*").append(tableBean.getAttempts().get(i).getWorkTime()).append(" ms");
                stringBuilder.append("*").append(tableBean.getAttempts().get(i).getIsHit());
            }
        return stringBuilder.toString();
    }
}
