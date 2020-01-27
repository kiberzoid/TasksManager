package dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import entity.Task;

@Repository
public class JDBCTaskRepositoryImpl implements TaskRepository {
	
	private static final String GET_TASK_SQL = "select * from tasks where id=?";
	private static final String GET_TASKS_SQL = "select * from tasks";
	private static final String ADD_TASK_SQL = "insert into tasks values(?,?)";
	private static final String DELETE_TASK_SQL = "delete from tasks where id=?";
	private static final String UPDATE_TASK_SQL = "update tasks set description=? where id=?";
	
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public List<Task> getTasks() {
		return jdbcOperations.query(GET_TASKS_SQL, (ResultSet rs, int rowCount) -> new Task(rs.getInt(1),rs.getString(2)));
	}

	@Override
	public Task getTask(int id) {
		return jdbcOperations.queryForObject(GET_TASK_SQL, (ResultSet rs, int rowNum) -> new Task(rs.getInt(1),rs.getString(2)), id);
	}

	@Override
	public int deleteTask(int id) {
		return jdbcOperations.update(DELETE_TASK_SQL, id);
	}

	@Override
	public int addTask(Task task) {
		return jdbcOperations.update(ADD_TASK_SQL, task.getId(), task.getDescription());
	}

	@Override
	public int updateTask(Task task) {
		return jdbcOperations.update(UPDATE_TASK_SQL, task.getDescription(), task.getId());
	}

}
