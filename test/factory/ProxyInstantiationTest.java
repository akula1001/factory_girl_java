package factory;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

class Actual {
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

@Setup(value = Actual.class)
class ActualSetup {
    public int x() {
        return 5;
    }
}

@Setup(value = Actual.class, name = "Alias")
class ActualSetupAsAlias {
    public int x() {
        return 10;
    }
}

class Proxy extends Actual {
    public Proxy(AbstractPersistenceHandler persistenceHandler) {
    }
}

@__SetupForProxy(value = Proxy.class, factory = "")
class ProxySetup {
}

public class ProxyInstantiationTest {

    @Test
    public void shouldInstantiateProxyUsingActualClassSetup() {
        assertEquals(5, Instantiator.createProxy(Proxy.class, "").getX());
        assertEquals(10, Instantiator.createProxy(Proxy.class, "Alias").getX());
    }
}