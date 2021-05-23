package chap12.CRUDsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) {
		/*
		 * JDBCドライバのロード
		 */
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try ( /*
				* DBMSとの接続
				*
				* JDBC URLは、環境に合わせて変更してください
				* ここでは「c:\Users\CodeCamp\test」にあるデータベースに接続しています
				*/
				Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\tanep\\OneDrive\\Programming\\Eclipse Project\\JavaCodeCampWorkspace\\JavaAdvanceOL\\src\\chap12\\H2DB\\test", "sa", "");

				/*
				 * PreparedStatementを使ってSQLの準備
				 */
				PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE goods_table(id INT PRIMARY KEY AUTO_INCREMENT, name varchar(50), price int)");) {

				pstmt.executeUpdate();
				System.out.println("goods_tableの作成が成功しました。");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
