public class example1 {
    public static final TableBean tableBean = new TableBean(); // here is some important objects for user
}

public class haker1 {
    public void destroyUserData() {
        example1.tableBean.getAttempts().clear(); // all data was removed
    }
}

public class example2 {
    public static final TableBean tableBean = new TableBean(); // here is some urls which we want to senRequest

    public static void doRequest() {
        for (Urls urls: tableBean.gerUrls) {
            //send a request
        }
    }
}

public class haker2 {
    public void changeUrls() {
        example2.tableBean.getUrls().add("http://unsecurity.com"); // you can modifed data which will call different problems such as visiting unsafety sites
    }
}
