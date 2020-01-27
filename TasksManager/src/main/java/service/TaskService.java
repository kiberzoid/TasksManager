package service;

import java.util.List;
import entity.Task;

public interface TaskService {
	public List<Task> getTasksList();
	public Task getTask(int id);
	public void addOrUpdateTask(Task task);
	public void deleteTask(int id);
}
