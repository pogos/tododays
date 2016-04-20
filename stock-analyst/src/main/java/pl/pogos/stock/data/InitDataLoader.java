package pl.pogos.stock.data;

import javax.annotation.PostConstruct;

public abstract class InitDataLoader {

    protected abstract void persistData();

    @PostConstruct
    public void loadData() {
        persistData();
    }
}
