package models;


import interfaces.PlanningStrategy;

public class TaskManager {
    private PlanningStrategy strategy;

    public TaskManager(PlanningStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PlanningStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePlanning(String task) {
        strategy.planTask(task);
    }

    public String getCurrentStrategyName() {
        return strategy.getStrategyName();
    }
}