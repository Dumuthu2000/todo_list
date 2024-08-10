import java.time.LocalDateTime;

public class TaskNode {
    int id;
    String description;
    boolean isCompleted;
    LocalDateTime time;  // Time of task creation
    TaskNode next;

    public TaskNode(int id, String description, LocalDateTime time) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
        this.time = time;
        this.next = null;
    }
}
