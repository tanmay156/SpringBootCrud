package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertUser(User user) {
		boolean status = false;
		try {
			String SqlInsert = "Insert into users(name, email, gender, city) values(?,?,?,?)";
			int count = jdbcTemplate.update(SqlInsert, user.getName(), user.getEmail(), user.getGender(),
					user.getCity());
			if (count > 0) {
				status = true;
			} else {
				status = false;
			}
		}

		catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	public boolean updateUser(User user) {
		boolean status2 = false;
		try {
			String SqlUpdate = "Update users Set name = ?, gender = ?, city = ? where email = ?";
			int count2 = jdbcTemplate.update(SqlUpdate, user.getName(), user.getGender(), user.getCity(),
					user.getEmail());
			if (count2 > 0) 
			{
				status2 = true;
			} 
			else
			{
				status2 = false;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status2;
	}
	
	public boolean deleteUserByEmail(String email) {
		boolean status3 = false;
		try {
			String SqlDelete = "delete from users where email = ?";
			int count3 = jdbcTemplate.update(SqlDelete, email);
			if (count3 > 0) 
			{
				status3 = true;
			} 
			else
			{
				status3 = false;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status3;
	}
	
	public List<User> getAllUsers()
	{
		String SqlSelectAll = "select * from users";
		return jdbcTemplate.query(SqlSelectAll, new UserRowMapper());
		
	}
	
	public User getUserByEmail(String email)
	{
		String SqlSelect = "select * from users where email=?";
		return jdbcTemplate.queryForObject(SqlSelect, new UserRowMapper(), email);
		
	}
	public static final class UserRowMapper implements RowMapper<User>
	{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user =new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
		
	}
}
