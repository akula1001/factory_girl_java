package factory;

public abstract class AbstractPersistenceHandler {

    protected String databaseName;

    public AbstractPersistenceHandler(String databaseName) {
        this.databaseName = databaseName;
    }

    public abstract void built(Object object);
}