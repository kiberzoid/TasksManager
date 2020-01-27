package dao;

import java.util.List;

import entity.Task;

public interface TaskRepository {
	public List<Task> getTasks();
	public Task getTask(int id);
	public int addTask(Task task);
	public int updateTask(Task task);
	public int deleteTask(int id);
}
