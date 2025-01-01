package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

public class Main2 implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//--------------------------- Insertion -----------------------------------
		User user = new User("Tanmay", "tanmay@gmail.com", "Male", "Nashik");
		//User user = new User("Pranav", "pranav@gmail.com", "Male", "Nashik");
		boolean status = userDao.insertUser(user);
		if(status)
		{
			System.out.println("User Inserted Successfully !");
		}
		else
		{
			System.out.println("User not inserted due to some error !");
		}
		
		
		//---------------------------- Updation 1 -------------------------------------
		
		User user3 = new User("Tanmay", "tanmay@gmail.com", "Male", "Pune");
		boolean status2 = userDao.updateUser(user3);
		
		if(status2)
		{
			System.out.println("User Updation Successfully !");
		}
		else
		{
			System.out.println("User not updated due to some error !");
		}
		
		//---------------------------- Updation 2 -------------------------------------
				
				User user5 = userDao.getUserByEmail("tanmay@gmail.com");
				user.setCity("Pune");
				boolean status5 = userDao.updateUser(user3);
				
				if(status2)
				{
					System.out.println("User Updation Successfully !");
				}
				else
				{
					System.out.println("User not updated due to some error !");
				}
				
		//---------------------------- Deletion -------------------------------------
		boolean status3 = userDao.deleteUserByEmail("tanmay@gmail.com");
				
		if(status3)
		{
			System.out.println("User Deletion Successfully !");
		}
		else
		{
			System.out.println("User not deleted due to some error !");
		}
		
		//-------------------------- Get One User Data ------------------------------
		User user4 = userDao.getUserByEmail("pranav@gmail.com");
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getGender());
		System.out.println(user.getCity());
		
		//------------------------ Select All User ----------------------------------
		
		List<User> list = userDao.getAllUsers();
		System.out.println("Name: "+user.getName());
		System.out.println("Email: "+ user.getEmail());
		System.out.println("Gender: "+user.getGender());
		System.out.println("City: "+user.getCity());
		
	}

}
