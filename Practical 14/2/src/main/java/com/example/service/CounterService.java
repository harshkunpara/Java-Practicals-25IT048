package com.example.service;

import com.example.model.Counter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public void save(Path file) throws IOException {
        Path parent = file.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.writeString(file, String.valueOf(getCount()));
    }

    public void load(Path file) throws IOException {
        int value = Integer.parseInt(Files.readString(file).trim());
        counter.setCount(value);
        history.clear();
        history.add("Loaded: " + value);
    }
}
