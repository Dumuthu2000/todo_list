import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoList {
    private TaskNode head;
    private int nextId = 1;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TodoList() {
        this.head = null;
    }

    //Create a new Task
    public void addTask(String description) {
        TaskNode newTask = new TaskNode(nextId++, description, LocalDateTime.now());
        if (head == null) {
            head = newTask;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }
    

    //Main method
    public static void main(String[] args) {

    }
}
