package stuff.devices;

import stuff.UsableObject;

public class Manual {

    private final UsableObject object;

    /**
     * The instance ot Manual.
     *
     * @param object the object that owns the manual
     */
    public Manual(UsableObject object) {
        this.object = object;
    }

    private static final String manualText =
            "Manual text for your broken ";

    /**
     * Reading the manual.
     */
    public void readManual() {
        System.out.println("Reading the manual...");
        System.out.println(manualText + object.getType());
    }
}










