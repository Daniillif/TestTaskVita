import java.util.Set;
import java.util.TreeSet;

//Свойства:
//i. Текущий этаж кабины 1
//j. Текущий статус кабины 1
//k. Текущий этаж кабины 2
//l. Текущий статус кабины 2
//m. Статус кнопки вызова лифта (вызван/не вызван)
//Методы:
//n. Нажать кнопку вызова лифта
public class Floor {
    private int currentFloor1Cab;
    private int currentFloor2Cab;
    private Status currentStatus1Cab;
    private Status currentStatus2Cab;
    private boolean isPushed = false;

    private Floor() {
        this.currentFloor1Cab = 1;
        this.currentFloor2Cab = 1;
        this.currentStatus1Cab = Status.ISSTANDINGWITHOPENDOORS;
        this.currentStatus2Cab = Status.ISSTANDINGWITHOPENDOORS;
        this.isPushed = false;
    }
    private void pushButton(){
        this.isPushed = true;
    }

    public int getCurrentFloor1Cab() {
        return currentFloor1Cab;
    }

    public void setCurrentFloor1Cab(int currentFloor1Cab) {
        this.currentFloor1Cab = currentFloor1Cab;
    }

    public int getCurrentFloor2Cab() {
        return currentFloor2Cab;
    }

    public void setCurrentFloor2Cab(int currentFloor2Cab) {
        this.currentFloor2Cab = currentFloor2Cab;
    }

    public Status getCurrentStatus1Cab() {
        return currentStatus1Cab;
    }

    public void setCurrentStatus1Cab(Status currentStatus1Cab) {
        this.currentStatus1Cab = currentStatus1Cab;
    }

    public Status getCurrentStatus2Cab() {
        return currentStatus2Cab;
    }

    public void setCurrentStatus2Cab(Status currentStatus2Cab) {
        this.currentStatus2Cab = currentStatus2Cab;
    }

    public boolean isPushed() {
        return isPushed;
    }

    public void setPushed(boolean pushed) {
        isPushed = pushed;
    }
}
