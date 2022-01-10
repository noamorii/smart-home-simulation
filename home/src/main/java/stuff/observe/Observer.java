package stuff.observe;

import stuff.UsableObject;

public interface Observer {

    /**
     * Handle the event and add the event to the adult's to-do list
     *
     * @param stuff        object to add to the to-do list
     */
    void handleEvent(UsableObject stuff);
}
