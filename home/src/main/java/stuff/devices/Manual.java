package stuff.devices;

import stuff.UsableObject;

public class Manual {

    private final UsableObject object;

    public Manual(UsableObject object) {
        this.object = object;
        manualText += object.getType();
    }

    private String manualText =
            "Manual text for your broken ";

    public void readManual() {
        System.out.println("Reading the manual...");
    }

    public String getManualText() {
        return manualText;
    }
}










