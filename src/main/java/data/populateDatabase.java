package data;

import data.xmlParser.parseMethodXML;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class populateDatabase {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/appCtx-database-populate.xml");

        applicationContext.getBean(parseMethodXML.class).run();
    }
}
