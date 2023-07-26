import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//Свойства:
//a. Этаж (где находится в данный момент времени кабина) для вывода на дисплее.
//b. Состояние (едет вверх/едет вниз/открывает двери/закрывает двери/стоит с
//открытыми дверьми)
//Методы:
//        c. Нажать кнопку этажа (1-20)
//        d. Нажать кнопку закрытия дверей
//        e. Нажать кнопку открытия дверей
//        f. Нажать кнопку вызова диспетчера
//        g. Датчик кабины фиксирует движение между дверьми
//        h. Датчик кабины фиксирует отсутствие движения между дверьми
public class ElevatorCab {
    private Status status;
    private Floor floor;
    private int numberOfCab;
    private boolean isMoving = false;

    public ElevatorCab() {
    }

    ElevatorCab(Status status, Floor floor, int numberOfCab) {
        this.status = status;
        this.floor = floor;
        this.numberOfCab = numberOfCab;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void pushButtonOfFloor(int targetFloor) throws InterruptedException {

        //вызов метода elevatorIsGoingToU
        if (numberOfCab == 1 &&
                (targetFloor > floor.getCurrentFloor1Cab() && targetFloor <= 20)) {
            this.floor.setCurrentStatus1Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status);
            for (int i = floor.getCurrentFloor1Cab(); i <= targetFloor; i++) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor1Cab(targetFloor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + targetFloor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        } else if (numberOfCab == 1 &&
                (targetFloor < floor.getCurrentFloor1Cab() && targetFloor >= 1)) {
            this.floor.setCurrentStatus1Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status);
            for (int i = floor.getCurrentFloor1Cab(); i >= targetFloor; i--) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor1Cab(targetFloor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + targetFloor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        } else if (numberOfCab == 2 &&
                (targetFloor < floor.getCurrentFloor1Cab() && targetFloor >= 1)) {
            this.floor.setCurrentStatus2Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status);
            for (int i = floor.getCurrentFloor1Cab(); i >= targetFloor; i--) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor2Cab(targetFloor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + targetFloor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        } else if (numberOfCab == 2 &&
                (targetFloor > floor.getCurrentFloor1Cab() && targetFloor <= 20)) {
            this.floor.setCurrentStatus2Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status);
            for (int i = floor.getCurrentFloor1Cab(); i <= targetFloor; i++) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor2Cab(targetFloor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + targetFloor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        } else
            System.out.println("Непредвиденная ошибка(возможно вы неправильно ввели этаж)");
        this.status = Status.ISSTANDINGWITHOPENDOORS;

    }

    public void pushButtonOfClosingDoors() {
        if (this.status.equals(Status.ISSTANDINGWITHOPENDOORS)) {
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        }

    }

    public void pushButtonOfOpeningDoors() {
        if (this.status.equals(Status.ISCLOSING)) {
            this.status = Status.ISOPENING;
            System.out.println(Status.ISOPENING.toString());
        }
    }

    public void pushButtonOfCallingToDispatcher() {
        System.out.println("CALL FOR HELP!!!!!!!!");
    }

    public boolean cabHasMoving() {
        do {
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);

        } while (isMoving);
        return true;
    }

    public boolean NoMoving() {
        if (!isMoving) {
            return false;
        } else return cabHasMoving();
    }

    public void elevatorIsGoingToU(int floor) throws InterruptedException {
        if (numberOfCab == 1 && floor < Floor.getCurrentFloor1Cab()) {
            this.floor.setCurrentStatus1Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status);
            for (int i = Floor.getCurrentFloor1Cab(); i >= floor; i--) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor1Cab(floor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + floor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        }else if (numberOfCab == 2 && floor < Floor.getCurrentFloor2Cab()){
            this.floor.setCurrentStatus2Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status);
            for (int i = Floor.getCurrentFloor2Cab(); i >= floor; i--) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor2Cab(floor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + floor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);

        }
        else if (numberOfCab == 1 && floor > Floor.getCurrentFloor1Cab()) {
            this.floor.setCurrentStatus1Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status);
            for (int i = Floor.getCurrentFloor1Cab(); i <= floor; i++) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor1Cab(floor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + floor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        }else if (numberOfCab == 2 && floor > Floor.getCurrentFloor1Cab()){
            this.floor.setCurrentStatus2Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status);
            for (int i = Floor.getCurrentFloor2Cab(); i <= floor; i++) {
                System.out.println("--- этаж " + i + "---");
                TimeUnit.SECONDS.sleep(1);
            }
            this.floor.setCurrentFloor2Cab(floor);
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + floor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);

        }else {
            this.status = Status.ISOPENING;
            System.out.println(this.status);
            this.status = Status.ISSTANDINGWITHOPENDOORS;
            System.out.println(this.status);
            System.out.println("Лифт на " + floor + " этаже.");
            this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING);
        }
        }
    }




