package pl.pogos.tododays.data;


public interface DataLoader {

    void loadData();

    default String getName() {
        return this.getClass().getName();
    }

}
