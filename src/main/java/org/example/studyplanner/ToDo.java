package org.example.studyplanner;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ToDo implements PlannerMaterial {
    private final Integer id;
    private String title;
    private String description;
    private int priority;
    private final List<LocalDateTime> executionTimes = new ArrayList<>();

    public ToDo(Integer id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void recordExecutionNow() {
        executionTimes.add(LocalDateTime.now());
    }

    public boolean matches(String searchTerm) {
        String term = searchTerm.toLowerCase();
        return title.toLowerCase().contains(term) || description.toLowerCase().contains(term);
    }

    public boolean hasHigherPriorityThan(ToDo other) {
        return this.priority < other.priority; // menor número = maior prioridade
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]\n", id, title, description, priority));

        if (executionTimes.isEmpty()) {
            str.append("No tracks found\n");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (LocalDateTime time : executionTimes) {
                str.append(formatter.format(time)).append("\n");
            }
        }
        return str.toString();
    }

    // Somente se os testes realmente exigirem:
    public Integer getId() {
        return id;
    }

    // getters/setters só se usados nos testes diretamente, remova o que não for necessário
}
