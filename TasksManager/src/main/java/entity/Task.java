package entity;

import javax.validation.constraints.Max;
import validator.DescriptionConstraint;

public class Task {
	
	@Max(value=15, message="{id.max}")
	private Integer id;
	
	@DescriptionConstraint(message="{description.length}")
	private String description;
	
	public Task(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		//System.out.println("!!!!!!!!!!!!!!!! getId()=" + id);
		return id;
	}

	public void setId(Integer id) {
		//System.out.println("!!!!!!!!!!!!!!!! setId()=" + id);
		this.id = id;
	}

	public String getDescription() {
		//System.out.println("!!!!!!!!!!!!!!!! getDescription()" + description);
		return description;
	}

	public void setDescription(String description) {
		//System.out.println("!!!!!!!!!!!!!!!! setDescription()=" + description);
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
