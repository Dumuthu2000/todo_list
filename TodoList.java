import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoList {
    private TaskNode head;
    private int nextId = 1;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TodoList() {
        this.head = null;
    }

    //Main method
    public static void main(String[] args) {

    }
}
