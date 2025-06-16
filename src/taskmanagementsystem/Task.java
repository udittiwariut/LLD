package taskmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    final private String id;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private final List<Comment> comments;
    private User assignee;
    private String title;

    public Task(User user, String title, TaskPriority priority, String description) {
        this.id = UUID.randomUUID().toString();
        this.comments = new ArrayList<>();
        this.assignee = user;
        this.priority = priority;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.title = title;
    }

    public synchronized void updateStatus(TaskStatus status) {
        this.status = status;
    }

    public synchronized void updatePriority(TaskPriority priority) {
        this.priority = priority;
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void assignUser(User assignee) {
        this.assignee = assignee;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskPriority getCurrentPriority() {
        return this.priority;
    }

}
