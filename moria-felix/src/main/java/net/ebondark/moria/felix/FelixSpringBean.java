package net.ebondark.moria.felix;

/**
 * Created by IntelliJ IDEA.
 * User: nebulus
 * Date: 01-08-11
 * Time: 23:58
 * To change this template use File | Settings | File Templates.
 */
public class FelixSpringBean {
    private FelixContainer felixContainer;

    public void setFelixContainer(FelixContainer felixContainer) {
        this.felixContainer = felixContainer;
    }

    public FelixContainer getFelixContainer() {
        return felixContainer;
    }
}
