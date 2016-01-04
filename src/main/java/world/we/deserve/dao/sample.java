/**
 * 
 */
package world.we.deserve.dao;

import java.util.Map;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@Table(value = "sample")
public class sample {
	
	public sample() {
		super();
	}
	

	@PrimaryKey
	private String userid;
	
	@Column(value = "todo")
	private Map todo;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Map getTodo() {
		return todo;
	}

	public void setTodo(Map todo) {
		this.todo = todo;
	}	
}

