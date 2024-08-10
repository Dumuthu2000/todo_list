import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TodoList {
    private TaskNode head;
    private int nextId = 1;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TodoList() {
        this.head = null;
    }

    //Create a new Task
    //Here new task add in the end of the list
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

    //Add new task to the beginning of the list
    void addTaskAtBeginning(String description) {
        TaskNode newTask = new TaskNode(nextId++, description, LocalDateTime.now());
        if(head == null){
            head = newTask;
            return;
        }
        newTask.next = head;
        head = newTask;
    }

    //View already created tasks
    void viewTasks() {
        if (head == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        TaskNode temp = head;
        while (temp != null) {
            String status = temp.isCompleted ? "Completed" : "Pending";
            System.out.println("ID: " + temp.id + ", Description: " + temp.description + ", Time: " + temp.time.format(formatter) + " - " + status);
            temp = temp.next;
        }
    }


    //Main method
    public static void main(String[] args) {
        TodoList toDoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        int choice;
    }
}
