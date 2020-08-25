package data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseBuild {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/appCtx-database-rebuid.xml");
    }
}
