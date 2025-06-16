package taskmanagementsystem;

import java.util.List;

public class TaskManagementSystemDemo {
    public static void run() {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User("John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task(user1, "Task 1", TaskPriority.LOW, "Description 1");
        Task task2 = new Task(user2, "Task 2", TaskPriority.MEDIUM, "Description 2");
        Task task3 = new Task(user1, "Task 3", TaskPriority.HIGH, "Description 3");

        // Add tasks to the task manager
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        // Update a task
        task2.setDescription("Updated task2 status");
        taskManager.updateTaskStatus(task2.getId(), TaskStatus.IN_PROGRESS);

        // Search tasks
        List<Task> searchResults = taskManager.searchTasks("Task");
        System.out.println("Tasks with keyword Task:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter tasks by status
        List<Task> filteredTasks = taskManager.listTasksByStatus(TaskStatus.TODO);
        System.out.println("TODO Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as done
        taskManager.updateTaskStatus(task2.getId(), TaskStatus.DONE);

        // Get tasks assigned to a user
        List<Task> taskHistory = taskManager.listTaskByBuyer(user1);
        System.out.println("Task for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskManager.deleteTask(task3.getId());
    }

    public static void main(String[] args) {
        run();
    }
}