interface Switchable {
    void on();
    void off();

    default void toggle() {
        System.out.println("Toggling device...");
    }
}

class Fan implements Switchable {
    boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Fan is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("Fan is OFF");
    }

    public void toggle() {
        if (isOn) {
            off();
        } else {
            on();
        }
    }
}

class Light implements Switchable {
    boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Light is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("Light is OFF");
    }

    public void toggle() {
        if (isOn) {
            off();
        } else {
            on();
        }
    }
}

@FunctionalInterface
interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}

public class RemoteControl {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule rule1 = new SwitchRule() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println(rule1.maySwitchOn(devices[0], 10));
        System.out.println(rule1.maySwitchOn(devices[0], 23));

        SwitchRule rule2 =
            (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println(rule2.maySwitchOn(devices[1], 10));
        System.out.println(rule2.maySwitchOn(devices[1], 23));
    }
}