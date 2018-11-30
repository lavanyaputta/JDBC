package S5_22_4.JDBC;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreFile {
	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

			PreparedStatement ps = con.prepareStatement("insert into filetable values(?,?)");

			File f = new File("C:\\Users\\Lavanya Putta\\Downloads\\new.txt");
			FileReader fr = new FileReader(f);

			ps.setInt(1, 102);
			ps.setCharacterStream(2, fr, (int) f.length());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}