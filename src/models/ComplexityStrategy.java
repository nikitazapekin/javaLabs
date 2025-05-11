package models;

import interfaces.PlanningStrategy;

public class ComplexityStrategy implements PlanningStrategy {
    @Override
    public void planTask(String task) {
        System.out.println("Планирование задачи '" + task + "' по сложности: простые задачи сначала");
    }

    @Override
    public String getStrategyName() {
        return "Стратегия планирования по сложности";
    }
}