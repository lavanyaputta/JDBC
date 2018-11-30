package S5_21_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class userinput {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		//step-2 to provide the connetion between java-database
		Connection connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		System.out.println("connetion is created......");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter eid: ");
		int eid = scanner.nextInt();
 
		System.out.print("please enter ename: ");
		String ename = scanner.nextLine();

		System.out.print("please enter esal: ");
		double esal = scanner.nextDouble();
	
	
		// 2. Create a statement
		String sql = "insert into emp values (?, ?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, eid);
		stmt.setString(2, ename);
		stmt.setDouble(3, esal);
		// 3. Execute SQL query
		int i=stmt.executeUpdate();
		if(i!=0){
			System.out.println("data inserted successfully");
		}else{
			System.out.println("unsuccess");
		}
	}

}
