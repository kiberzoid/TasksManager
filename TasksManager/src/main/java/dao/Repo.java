package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import entity.Task;


public class Repo {
	private ArrayList<Task> list;
	
	public Repo(){
		list = new ArrayList<Task>();
		list.add(new Task(1,"Task with id 1"));
		list.add(new Task(2,"Task with id 2"));
		list.add(new Task(3,"Task with id 3"));
		list.add(new Task(4,"Task with id 4"));
		list.add(new Task(5,"Task with id 5"));
		list.add(new Task(6,"Task with id 6"));
		list.add(new Task(7,"Task with id 7"));
		list.add(new Task(8,"Task with id 8"));
		list.add(new Task(9,"Task with id 9"));
	}
	
	public ArrayList<Task> getList() {
		return list;
	}
	
	public void addTask(Task task) {
		System.out.println("ADD TASK");
		list.add(task);
	}
	
	public void updateTask(Task task) {
		System.out.println("UPDATE TASK");
		list.forEach(i -> {
			if(i.getId()==task.getId()) {
				i.setDescription(task.getDescription());
			}
		});
	}
}
