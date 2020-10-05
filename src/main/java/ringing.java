import data.dto.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static data.gen.methodGen.getMethodFromUser;

public class ringing implements Runnable {

    private final Logger log = LogManager.getLogger(runMain.class);

    @Override
    public void run() {
        main();
    }

    public void main() {
        log.info("Program start");
        Method workingMethod = getMethodFromUser();
    }
}