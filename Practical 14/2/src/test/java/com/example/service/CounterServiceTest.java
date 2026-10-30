package com.example.service;

import com.example.model.Counter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CounterServiceTest {
    @TempDir
    Path tempDir;

    @Test
    void addingIncreasesCount() {
        CounterService service = new CounterService();
        service.add();
        assertEquals(1, service.getCount());
    }

    @Test
    void negativeCountThrowsException() {
        Counter counter = new Counter();
        assertThrows(IllegalArgumentException.class, () -> counter.setCount(-1));
    }

    @Test
    void savingAndLoadingPreservesCount() throws Exception {
        CounterService original = new CounterService();
        original.add();
        original.add();
        original.add();

        Path file = tempDir.resolve("counter.txt");
        original.save(file);

        CounterService restored = new CounterService();
        restored.load(file);

        assertEquals(3, restored.getCount());
    }
}
