package stuff.observe;

import java.io.IOException;

public interface Observed {

    /**
     * Positronic brain notification of an incident
     */
    void notifyObserver() throws IOException;
}
