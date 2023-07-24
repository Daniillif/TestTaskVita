//Состояние (едет вверх/едет вниз/открывает двери/закрывает двери/
// стоит с открытыми дверьми)

public enum Status {
    ISGOINGUP("Едет вверх"),
    ISGOINGDOWN("Едет вниз"),
    ISOPENING("Открывает двери"),
    ISCLOSING("Закрывает двери"),
    ISSTANDINGWITHOPENDOORS("Стоит с открытыми дверьми");
    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }



    @Override
    public String toString() {
        return "Лифт" +
                  status ;
    }
}
