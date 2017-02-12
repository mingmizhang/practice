import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangmingmi on 16/10/10.
 */
public class Philisopher extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Philisopher.class);
    private static int Number = -1;
    private int phiNumber;
    private boolean status = false;
    private static int chopStickNumber = 5;
    //筷子列表定义
    private static List<ChopStick> chopSticks = new ArrayList<ChopStick>();

    public Philisopher() {
        Number++;
        phiNumber = Number;

    }

    public static void initChopStickArray() {
        for (int i = 0; i < chopStickNumber; i++) {
            chopSticks.add(new ChopStick());
        }
    }

    public int getPhiNumber() {
        return phiNumber;
    }

    public boolean getLeftChopstickStatus() {
        return chopSticks.get(phiNumber).getIsStickAvailable();
    }

    public void setLeftChopstickStatus(boolean status) {
        chopSticks.get(phiNumber).setIsStickAvailable(status);
    }

    public boolean getRightChopstickStatus() {
        if (phiNumber == 0) {
            return chopSticks.get(chopSticks.size() - 1).getIsStickAvailable();
        } else {
            return chopSticks.get(phiNumber - 1).getIsStickAvailable();
        }
    }

    public void setRightChopstickStatus(boolean status) {
        if (phiNumber == 0) {
            chopSticks.get(chopSticks.size() - 1).setIsStickAvailable(status);
        } else {
            chopSticks.get(phiNumber - 1).setIsStickAvailable(status);
        }
    }

    public void putRightChopStickStatus() {
        if (getRightChopstickStatus() == false) {
            setRightChopstickStatus(true);
        }
    }

    public void putLeftChopStickStatus() {
        if (getLeftChopstickStatus() == false) {
            setLeftChopstickStatus(true);
        }
    }


    public void putChopsticks() {
        putRightChopStickStatus();
        putLeftChopStickStatus();
    }


    public void thinking() {
        if (!(getLeftChopstickStatus() && getRightChopstickStatus()))
            putChopsticks();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            logger.info("The Philospher eating is interrupted ~~");

        } finally {
            logger.info("The philospher {} thinking end ~", getPhiNumber());

        }

    }

    public void eat() {
        try {
            if (getPhiNumber() % 2 == 0) {
                if (getLeftChopstickStatus()) {
                    setLeftChopstickStatus(false);
                    if (getRightChopstickStatus()) {
                        setRightChopstickStatus(false);
                        logger.info("The philospher {} start eating now ~~~",getPhiNumber());
                        sleep(500);
                    } else {
                        int loopTime=0;
                        while((!getRightChopstickStatus())&&loopTime<200) {
                            loopTime++;
                            sleep(5);
                        }
                        if(loopTime<200){
                            setRightChopstickStatus(false);
                            logger.info("The philospher {} start eating now ~~~",getPhiNumber());
                            sleep(500);
                        }else{
                            logger.info("The philospher waiting chopsticktimeout ~~~");
                        }
                    }
                }

            } else {
                if (getRightChopstickStatus()) {
                    setRightChopstickStatus(false);
                    if (getLeftChopstickStatus()) {
                        setLeftChopstickStatus(false);
                        logger.info("The philospher {} start eating now ~~~",getPhiNumber());
                        sleep(500);
                    } else {
                        {
                            int loopTime=0;
                            while((!getLeftChopstickStatus())&&loopTime<200) {
                                loopTime++;
                                sleep(5);
                            }
                            if(loopTime<200){
                                setLeftChopstickStatus(false);
                                logger.info("The philospher {} start eating now ~~~",getPhiNumber());
                                sleep(500);
                            }else{
                                logger.info("The philospher waiting chopstick timeout ~~~");
                            }
                        }
                    }
                }

            }
        } catch (InterruptedException e) {
            logger.info("Interrupted exception when sleep ~~~");
        }

        putChopsticks();
    }


    public void run() {
        while (true) {
            thinking();
            eat();
        }
    }


    public static void main(String[] args) {
        Philisopher.initChopStickArray();
        for(int i=0;i<5;i++){
            new Philisopher().start();
        }

    }

}

