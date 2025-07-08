package org.example.studyregistry;

import java.time.LocalDateTime;

public class StudyObjective extends Registry {

    private Integer id;
    private String name;
    private Integer priority;
    private boolean isActive;

    private String title;
    private String description;
    private String topic;
    private String objectiveInOneLine;
    private String objectiveFullDescription;
    private String motivation;

    private Integer practicedDays;
    private LocalDateTime startDate;
    private Double duration;

    public StudyObjective(String title, String description) {
        this.title = title;
        this.description = description;
        this.name = title;
    }

    // Método principal reduzido a poucos parâmetros (exemplo 5)
    public void handleSetObjective(
            Integer id,
            Integer priority,
            boolean isActive,
            String name,
            String title
    ) {
        setRegistry(id, name, priority, isActive);
        setTextualPartial(title);
    }

    // Primeiro método parcial para parte textual
    public void handleSetTextualInfo(
            String description,
            String topic,
            String objectiveInOneLine,
            String objectiveFullDescription,
            String motivation
    ) {
        setTextualInfo(description, topic, objectiveInOneLine, objectiveFullDescription, motivation);
    }

    // Segundo método parcial para tempo
    public void handleSetTimeInfo(
            Integer practicedDays,
            int day,
            int month,
            int year,
            Double duration
    ) {
        setTime(practicedDays, day, month, year, duration);
    }

    private void setRegistry(Integer id, String name, Integer priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isActive = isActive;
    }

    private void setTextualPartial(String title) {
        this.title = title;
    }

    private void setTextualInfo(String description, String topic,
                                String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        this.description = description;
        this.topic = topic;
        this.objectiveInOneLine = objectiveInOneLine;
        this.objectiveFullDescription = objectiveFullDescription;
        this.motivation = motivation;
    }

    private void setTime(Integer practicedDays, int day, int month, int year, Double duration) {
        this.practicedDays = practicedDays;
        this.duration = duration;
        this.startDate = LocalDateTime.of(year, month, day, 0, 0);
    }
}
