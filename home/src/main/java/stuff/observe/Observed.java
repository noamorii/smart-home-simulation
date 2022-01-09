package stuff.observe;

import java.io.IOException;

public interface Observed {

    void notifyObserver() throws IOException;
}
