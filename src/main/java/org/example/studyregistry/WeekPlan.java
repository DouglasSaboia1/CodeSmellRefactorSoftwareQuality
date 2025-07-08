package org.example.studyregistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekPlan {
    private List<String> responsibilities;

    // Construtor que aceita um array de Strings
    public WeekPlan(String... properties) {
        this.responsibilities = new ArrayList<>(Arrays.asList(properties));
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }
}
