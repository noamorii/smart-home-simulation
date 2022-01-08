package stuff.devices;

import stuff.UsableObject;

public class Manual {

    private final UsableObject object;
    private final static int READING_TIME = 3;

    public Manual(UsableObject object) {
        this.object = object;
        manualText += object.getType();
    }

    private String manualText =
            "Manual text for your broken ";

    public void readManual() {
        System.out.println("Reading the manual...");
        System.out.println(manualText + object.getType());
    }

    public String getManualText() {
        return manualText;
    }

    public int getReadingTime() {
        return READING_TIME;
    }
}










