package org.example.studyplanner;

import java.util.ArrayList;
import java.util.List;

public class TodoTracker {
    private List<ToDo> toDos = new ArrayList<>();
    private Integer nextId;
    private static TodoTracker instance;

    private TodoTracker() {
        this.toDos = new ArrayList<>();
        this.nextId = 1;
    }

    public static TodoTracker getInstance() {
        if (instance == null) {
            instance = new TodoTracker();
        }
        return instance;
    }

    @Override
    public String toString() {
        if (toDos.isEmpty()) {
            return "No ToDos found";
        }

        StringBuilder str = new StringBuilder();
        for (ToDo toDo : toDos) {
            str.append(toDo.toString());
        }
        return str.toString();
    }

    public void addToDoExecutionTime(Integer id) {
        ToDo toDo = getToDoById(id);
        if (toDo != null) {
            toDo.recordExecutionNow();
        }
    }

    public List<ToDo> getToDos() {
        return new ArrayList<>(toDos); // retorno seguro
    }

    public ToDo getToDoById(Integer id) {
        for (ToDo toDo : toDos) {
            if (toDo.getId().equals(id)) {
                return toDo;
            }
        }
        return null;
    }

    public Integer addToDo(String title, String description, Integer priority) {
        ToDo toAdd = new ToDo(nextId, title, description, priority);
        nextId++;
        this.toDos.add(toAdd);
        return toAdd.getId();
    }

    public void removeToDo(Integer id) {
        toDos.removeIf(toDo -> toDo.getId().equals(id));
    }

    public List<ToDo> sortTodosByPriority() {
        List<ToDo> sorted = new ArrayList<>(toDos);
        sorted.sort((a, b) -> {
            if (a.hasHigherPriorityThan(b)) return -1;
            if (b.hasHigherPriorityThan(a)) return 1;
            return 0;
        });
        return sorted;
    }

    public List<String> searchInTodos(String search) {
        List<String> result = new ArrayList<>();
        for (ToDo toDo : toDos) {
            if (toDo.matches(search)) {
                result.add(toDo.toString());
            }
        }
        return result;
    }
}
