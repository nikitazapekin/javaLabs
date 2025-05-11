package models;


import interfaces.PlanningStrategy;

public class PriorityStrategy implements PlanningStrategy {
    @Override
    public void planTask(String task) {
        System.out.println("Планирование задачи '" + task + "' по приоритету: высокий > средний > низкий");
    }

    @Override
    public String getStrategyName() {
        return "Стратегия планирования по приоритету";
    }
}