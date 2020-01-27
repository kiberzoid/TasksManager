package service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import dao.Repo;
import entity.Task;


public class TaskServiceImpl implements TaskService{

	@Autowired
	private Repo repo;
	
	@Override
	public ArrayList<Task> getTasksList() {
		return repo.getList();
	}

	@Override
	public Task getTask(int id) {
		ArrayList<Task> list = repo.getList();
		for(Task task : list) {
			if(task.getId() == id) return task;
		}
		return null;
	}

	@Override
	public void addOrUpdateTask(Task task) {
		ArrayList<Task> list = repo.getList();
		for(Task i : list) {
			if(i.getId() == task.getId()) {
				repo.updateTask(task);
				return;
			}
		}
		repo.addTask(task);
	}

	@Override
	public void deleteTask(final int id) {
		ArrayList<Task> list = repo.getList();
		list.removeIf(task -> task.getId()==id);
		return;
	}

}
