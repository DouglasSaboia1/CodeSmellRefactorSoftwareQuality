package org.example.studyregistry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task extends Registry {
    private String title;
    private String description;
    private String author;
    private LocalDateTime date;

    public Task(String title, String description, String author, LocalDateTime date) {
        this.title = title;
        this.name = title; // 'name' herdado de Registry
        this.description = description;
        this.author = author;
        this.date = date;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.name = title; // manter sincronizado com o campo herdado
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // ✅ Comportamentos adicionados (refatoração de classe de dados)

    /** Verifica se a tarefa está atrasada */
    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(date);
    }

    /** Retorna o resumo da tarefa em formato amigável */
    public String getSummary() {
        return String.format("Task: %s\nAuthor: %s\nDue: %s",
                title,
                author,
                getFormattedDate());
    }

    /** Retorna a data formatada como dd/MM/yyyy HH:mm */
    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    /** Atualiza a data para o momento atual */
    public void updateDateToNow() {
        this.date = LocalDateTime.now();
    }

    /** Retorna uma descrição resumida (máx. 50 caracteres) */
    public String getShortDescription() {
        return description.length() > 50 ? description.substring(0, 47) + "..." : description;
    }
}
