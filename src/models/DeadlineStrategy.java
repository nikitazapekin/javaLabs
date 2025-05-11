package models;


import interfaces.PlanningStrategy;

public class DeadlineStrategy implements PlanningStrategy {
    @Override
    public void planTask(String task) {
        System.out.println("Планирование задачи '" + task + "' по дедлайну: самые срочные сначала");
    }

    @Override
    public String getStrategyName() {
        return "Стратегия планирования по дедлайну";
    }
}
