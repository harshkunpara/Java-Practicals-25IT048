import java.util.ArrayList;

public class CounterService {
    private final Counter counter = new Counter();
    private final ArrayList<String> history = new ArrayList<>();

    public void add() {
        counter.increment();
        history.add("Added: " + counter.getCount());
    }

    public int getCount() {
        return counter.getCount();
    }

    public ArrayList<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void performAction(int action) {
        if (action == 1) {
            add();
        } else if (action != 0) {
            throw new IllegalArgumentException("Invalid action");
        }
    }
}
