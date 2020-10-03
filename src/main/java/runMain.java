
import data.dto.Method;
import data.xmlParser.parseMethodXML;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class runMain {

    private final Logger log = LogManager.getLogger(runMain.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/appCtx-database-main.xml");

        applicationContext.getBean(parseMethodXML.class).run();
    }

    public void run() {
        runMain();
    }

    public void runMain() {
        log.info("Program start");
        Method workingMethod;
    }
}
