import org.apache.commons.logging.impl.SimpleLog;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        SimpleLog logger = new SimpleLog("OpenLog");
        logger.setLevel(SimpleLog.LOG_LEVEL_INFO);
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyy hh:mm:ss SSS");
        Date d1 = new Date();
        logger.info("before " + df.format(d1));
        try {
            Thread.sleep((int) (Math.random() * 5023));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();
        logger.info("after " + df.format(d2));
        logger.setLevel(SimpleLog.LOG_LEVEL_DEBUG);
        int diff = (int) (d2.getTime() - d1.getTime());
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(2);

        int ms = diff % 1000;
        int s = diff / 1000 % 60;
        int m = diff / 1000 / 60;

        logger.debug("diff: " + nf.format(m) + ":" + nf.format(s) + " " + ms);
    }
}