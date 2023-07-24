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

    public ElevatorCab() {
    }

    private ElevatorCab(Status status, Floor floor, int numberOfCab) {
        this.status = status;
        this.floor = floor;
        this.numberOfCab = numberOfCab;
    }
    private void pushButtonOfFloor(int targetFloor){
        this.status = Status.ISCLOSING;
        System.out.println(Status.ISCLOSING.toString());
        if (numberOfCab==1 && (targetFloor>floor.getCurrentFloor1Cab() && targetFloor<=20)){
            this.floor.setCurrentFloor1Cab(targetFloor);
            this.floor.setCurrentStatus1Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status.toString());
            System.out.println(this.floor.toString());
        } else if (numberOfCab==1 && (targetFloor<floor.getCurrentFloor1Cab() && targetFloor>=1)){
            this.floor.setCurrentFloor1Cab(targetFloor);
            this.floor.setCurrentStatus1Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status.toString());
            System.out.println(this.floor.toString());
        }
        else if (numberOfCab==2 && (targetFloor<floor.getCurrentFloor1Cab() && targetFloor>=1)){
            this.floor.setCurrentFloor2Cab(targetFloor);
            this.floor.setCurrentStatus2Cab(Status.ISGOINGDOWN);
            this.status = Status.ISGOINGDOWN;
            System.out.println(this.status.toString());
            System.out.println(this.floor.toString());

        }else if(numberOfCab==2 && (targetFloor>floor.getCurrentFloor1Cab() && targetFloor<=20)){
            this.floor.setCurrentFloor2Cab(targetFloor);
            this.floor.setCurrentStatus2Cab(Status.ISGOINGUP);
            this.status = Status.ISGOINGUP;
            System.out.println(this.status.toString());
            System.out.println(this.floor.toString());
        }else
            this.status = Status.ISSTANDINGWITHOPENDOORS;

        }
        public void pushButtonOfClosingDoors(){
        this.status = Status.ISCLOSING;
            System.out.println(Status.ISCLOSING.toString());
        }
    public void pushButtonOfOpeningDoors(){
        this.status = Status.ISOPENING;
        System.out.println(Status.ISOPENING.toString());
    }
    public void pushButtonOfCallingToDispatcher(){
        this.status = Status.ISSTANDINGWITHOPENDOORS;
        System.out.println("CALL FOR HELP!!!!!!!!");
    }


}


