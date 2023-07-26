//Создать объекты описанных классов для моделирования работы 2 лифтов на 20 этажах.
//Исходное положение лифтов – 1 этаж
//3. Написать метод, который имитирует действия пассажиров:
//a. Пассажир 1 вызывает лифт на 1м этаже и поднимается на 14 этаж
//b. Пассажир 2 вызывает лифт на 15 этаже и опускается на 1 этаж
//4. Все действия пассажиров и изменения статусов лифтов должны выводиться в консольное
//окно
public class Main {
    static Floor the1Floor=  new Floor();
    Floor the2Floor=  new Floor();
    Floor the3Floor=  new Floor();
    Floor the4Floor=  new Floor();
    Floor the5Floor=  new Floor();
    Floor the6Floor=  new Floor();
    Floor the7Floor=  new Floor();
    Floor the8Floor=  new Floor();
    Floor the9Floor=  new Floor();
    Floor the10Floor=  new Floor();
    Floor the11Floor=  new Floor();
    Floor the12Floor=  new Floor();
    Floor the13Floor=  new Floor();
    Floor the14Floor=  new Floor();
    Floor the15Floor=  new Floor();
    Floor the16Floor=  new Floor();
    Floor the17Floor=  new Floor();
    Floor the18Floor=  new Floor();
    Floor the19Floor=  new Floor();
    Floor the20Floor=  new Floor();
    static ElevatorCab the1Cab = new ElevatorCab(Status.ISSTANDINGWITHOPENDOORS,the1Floor,1);
    static ElevatorCab the2Cab = new ElevatorCab(Status.ISSTANDINGWITHOPENDOORS,the1Floor,2);
    public static void the1Passenger() throws InterruptedException {
    the1Cab.elevatorIsGoingToU(1);
        System.out.println("Заходите в лифт");
    the1Cab.pushButtonOfFloor(14);
    }
    public  static void the2Passenger() throws InterruptedException {
        the2Cab.elevatorIsGoingToU(15);
        System.out.println("Заходите в лифт");
        the2Cab.pushButtonOfFloor(1);
    }

    public static void main(String[] args) throws InterruptedException {
        the1Passenger();
        System.out.println("__________________________\t________________");
        the2Passenger();
    }
}
