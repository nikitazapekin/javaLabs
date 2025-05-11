package interfaces;


public interface PlanningStrategy {
    void planTask(String task);
    String getStrategyName();
}