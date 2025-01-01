package in.sp.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringJdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Insert User");
			System.out.println("2. Update User");
			System.out.println("3. Delete User");
			System.out.println("4. Get User by Email");
			System.out.println("5. Get All Users");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1: // Insert User
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Email: ");
				String email = scanner.nextLine();
				System.out.print("Enter Gender: ");
				String gender = scanner.nextLine();
				System.out.print("Enter City: ");
				String city = scanner.nextLine();

				User user = new User(name, email, gender, city);
				if (userDao.insertUser(user)) {
					System.out.println("User Inserted Successfully!");
				} else {
					System.out.println("Error: User not inserted.");
				}
				break;

			case 2: // Update User
				System.out.print("Enter Email of User to Update: ");
				String updateEmail = scanner.nextLine();
				User existingUser = userDao.getUserByEmail(updateEmail);

				if (existingUser != null) {
					System.out.print("Enter New City: ");
					String newCity = scanner.nextLine();
					existingUser.setCity(newCity);

					if (userDao.updateUser(existingUser)) {
						System.out.println("User Updated Successfully!");
					} else {
						System.out.println("Error: User not updated.");
					}
				} else {
					System.out.println("Error: User not found.");
				}
				break;

			case 3: // Delete User
				System.out.print("Enter Email of User to Delete: ");
				String deleteEmail = scanner.nextLine();
				if (userDao.deleteUserByEmail(deleteEmail)) {
					System.out.println("User Deleted Successfully!");
				} else {
					System.out.println("Error: User not deleted.");
				}
				break;

			case 4: // Get User by Email
				System.out.print("Enter Email of User: ");
				String searchEmail = scanner.nextLine();
				User foundUser = userDao.getUserByEmail(searchEmail);

				if (foundUser != null) {
					System.out.println("Name: " + foundUser.getName());
					System.out.println("Email: " + foundUser.getEmail());
					System.out.println("Gender: " + foundUser.getGender());
					System.out.println("City: " + foundUser.getCity());
				} else {
					System.out.println("Error: User not found.");
				}
				break;

			case 5: // Get All Users
				List<User> users = userDao.getAllUsers();
				System.out.println("\nAll Users:");
				for (User u : users) {
					System.out.println("Name: " + u.getName() + ", Email: " + u.getEmail() + ", Gender: "
							+ u.getGender() + ", City: " + u.getCity());
				}
				break;

			case 6: // Exit
				System.out.println("Exiting program. Goodbye!");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
