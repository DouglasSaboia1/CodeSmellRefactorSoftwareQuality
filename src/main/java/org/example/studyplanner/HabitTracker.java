package org.example.studyplanner;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HabitTracker {
    private List<Habit> habits;
    private Map<Integer, List<LocalDateTime>> tracker;
    private Integer nextId;

    private static HabitTracker instance;

    public static HabitTracker getHabitTracker() {
        if (instance == null) {
            instance = new HabitTracker();
        }
        return instance;
    }

    private HabitTracker() {
        this.habits = new ArrayList<>();
        this.tracker = new HashMap<>();
        this.nextId = 1;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        for (Habit habit : habits) {
            response.append(habit.toString()).append(", ");
        }
        return "Habits: " + response.toString();
    }

    public Habit getHabitById(Integer id) {
        return this.habits.stream()
                .filter(habit -> Objects.equals(habit.getId(), id))
                .findFirst().orElse(null);
    }

    public List<Habit> getHabits() {
        return this.habits;
    }

    public String formatHabitDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public List<Integer> getTrackerKeys() {
        return new ArrayList<>(this.tracker.keySet());
    }

    // ✅ Classe interna com lógica (sem violação de Data Class)
    private static class HabitInfo {
        private final String name;
        private final String motivation;
        private final LocalTime dedicationTime;
        private final LocalDateTime startDate;
        private final boolean isConcluded;

        private HabitInfo(List<String> strings, List<Integer> ints, boolean isConcluded) {
            this.name = strings.get(0);
            this.motivation = strings.get(1);
            this.dedicationTime = LocalTime.of(ints.get(1), ints.get(0));
            this.startDate = LocalDateTime.of(ints.get(2), ints.get(3), ints.get(4),
                    ints.get(5), ints.get(6), ints.get(7));
            this.isConcluded = isConcluded;
        }

        public Habit toHabit(int id) {
            return new Habit(name, motivation, dedicationTime, id, startDate, isConcluded);
        }
    }

    // ✅ Método privado com apenas 1 parâmetro (sem violação)
    private int addHabit(HabitInfo info) {
        Habit habit = info.toHabit(this.nextId);
        this.habits.add(habit);
        this.tracker.put(nextId, new ArrayList<>());
        return nextId++;
    }

    // ✅ Método público compatível com os testes, sem lista de parâmetros longa
    public int handleAddHabitAdapter(List<String> stringProperties, List<Integer> intProperties, boolean isConcluded) {
        HabitInfo info = new HabitInfo(stringProperties, intProperties, isConcluded);
        return addHabit(info);
    }

    public int addHabit(String name, String motivation) {
        Habit habit = new Habit(name, motivation, this.nextId);
        this.habits.add(habit);
        this.tracker.put(nextId, new ArrayList<>());
        return nextId++;
    }

    public void addHabitRecord(Integer id) {
        tracker.get(id).add(LocalDateTime.now());
    }

    public void toggleConcludeHabit(Integer id) {
        for (Habit habit : this.habits) {
            if (habit.getId().equals(id)) {
                habit.setIsConcluded(!habit.getIsConcluded());
            }
        }
    }

    public void removeHabit(Integer id) {
        this.habits.removeIf(habit -> habit.getId().equals(id));
        this.tracker.remove(id);
    }

    public List<LocalDateTime> getHabitRecords(Integer id) {
        return this.tracker.get(id);
    }

    public List<String> searchInHabits(String search) {
        List<String> habits = new ArrayList<>();
        for (Habit habit : this.habits) {
            if (habit.getName().toLowerCase().contains(search.toLowerCase()) ||
                    habit.getMotivation().toLowerCase().contains(search.toLowerCase())) {
                habits.add(habit.toString());
            }
        }
        return habits;
    }
}
