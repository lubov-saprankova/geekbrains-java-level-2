package ilya_v.java2.lesson_1.competitors;

public interface Competitor {
    void run(int distance);
    void swim(int distance);
    void jump(int height);
    boolean isOnDistance();
    void showResult();
    String getName();
    String getType();
}
