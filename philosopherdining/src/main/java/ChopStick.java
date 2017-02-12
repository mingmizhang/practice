/**
 * Created by zhangmingmi on 16/10/10.
 */
public class ChopStick {
    private boolean isStickAvailable = false;
    private int stickNumber = 0 ;
    private static int Num = -1;

    public boolean getIsStickAvailable() {
        return isStickAvailable;
    }

    public void setIsStickAvailable(boolean stickStatus) {
        this.isStickAvailable = stickStatus;
    }

    public ChopStick() {
        Num++;
        this.stickNumber = Num;
        this.isStickAvailable = false;
    }


}
