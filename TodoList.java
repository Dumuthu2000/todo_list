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

    // Remove the task by given ID
    void removeTask(int id) {
        if (head == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            return;
        }
        TaskNode temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
        }
    }


    //Remove a task from the beginning of the List
    void removeTaskAtBeginning() {
        if (head == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        head = head.next;
    }


    //Remove a task from the end of the list
    void removeTaskAtEnd() {
        if (head == null) {
            System.out.println("The to-do list is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        TaskNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
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

    //updating task by id
    void updateTask(int id, String newDescription) {
        TaskNode temp = findTask(id);
        if (temp == null) {
            System.out.println("Task not found.");
        } else {
            temp.description = newDescription;
        }
    }

    // get task to update
    private TaskNode findTask(int id) {
        TaskNode temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        return temp;
    }


    //Main method
    public static void main(String[] args) {
        TodoList toDoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Task");
            System.out.println("2. Add Task at Beginning");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    description = scanner.nextLine();
                    toDoList.addTaskAtBeginning(description);
                    break;
                case 3:
                    toDoList.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    toDoList.removeTask(removeId);
                    break;
                case 5:
                    toDoList.removeTaskAtBeginning();
                    break;
                case 6:
                    toDoList.removeTaskAtEnd();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
