import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CounterServiceTest {

    @Test
    void addingIncreasesCount() {
        CounterService service = new CounterService();

        service.add();

        assertEquals(1, service.getCount());
    }

    @Test
    void invalidActionThrowsException() {
        CounterService service = new CounterService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.performAction(99)
        );
    }

    @Test
    void newServiceStartsAtZero() {
        CounterService service = new CounterService();

        assertEquals(0, service.getCount());
    }
}
