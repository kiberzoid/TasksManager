package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.TaskRepository;
import entity.Task;

@Service
public class JDBCTaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository repo;

	@Override
	public List<Task> getTasksList() {
		return repo.getTasks();
	}

	@Override
	public Task getTask(int id) {
		return repo.getTask(id);
	}

	@Override
	public void addOrUpdateTask(Task task) {
		List<Task> tasks = repo.getTasks();
		if(tasks.stream().anyMatch((Task t) -> {
			if(task.equals(t)) {return true;}
			else {return false;}
		})) {
			repo.updateTask(task);
			return;
		}
		repo.addTask(task);
	}

	@Override
	public void deleteTask(int id) {
		repo.deleteTask(id);
	}

}
