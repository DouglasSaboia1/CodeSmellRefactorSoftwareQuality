package org.example.studysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLog {
    private List<String> searchHistory;
    private Map<String, Integer> searchCount;
    private boolean isLocked;
    private int numUsages;
    private String logName;

    public SearchLog(String logName) {
        this.searchHistory = new ArrayList<>();
        this.searchCount = new HashMap<>();
        this.isLocked = false;
        this.numUsages = 0;
        this.logName = logName;
    }

    /**
     * Registra uma nova busca, se o log não estiver bloqueado.
     */
    public void logSearch(String searchTerm) {
        if (!isLocked) {
            searchHistory.add(searchTerm);
            numUsages++;
            searchCount.put(searchTerm, searchCount.getOrDefault(searchTerm, 0) + 1);
        }
    }

    /**
     * Retorna a mensagem padrão de log.
     */
    public String getLogMessage() {
        return "\nLogged in: " + logName;
    }

    // Getters públicos apenas para leitura externa, protegendo o encapsulamento
    public List<String> getSearchHistory() {
        return new ArrayList<>(searchHistory);
    }

    public Map<String, Integer> getSearchCount() {
        return new HashMap<>(searchCount);
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getNumUsages() {
        return numUsages;
    }

    public String getLogName() {
        return logName;
    }
}
