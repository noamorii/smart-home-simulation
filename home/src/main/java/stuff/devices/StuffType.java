package stuff.devices;


import java.util.Objects;

public enum StuffType {
    CONDITIONER("conditioner"),
    AUDIO_SYSTEM("audio_system"),
    COMPUTER("computer"),
    FRIDGE("fridge"),
    PET_TOY("pet_toy"),
    PET_FEEDER("pet_feeder"),
    PHONE("phone"),
    VACUUM("vacuum"),
    TV("tv"),
    BIKE("bike"),
    TREADMILL("treadmill"),
    STEPPER("stepper"),
    ORBITREK("orbitrek"),
    AUTO("auto");

    private final String name;

    /**
     * Types of Usable Objects
     */
    StuffType(String name) {
        this.name = name;
    }

    public static StuffType getTypeByName(String name) {
        for (StuffType stuff : StuffType.values()) {
            if (Objects.equals(stuff.name, name)) return stuff;
        }
        return null;
    }
}
