package chap12.CRUDsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

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
				PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM goods_table");) {

			try (
					/*
					 * executeQuery()メソッドでSQLを実行
					 */
					ResultSet rs = pstmt.executeQuery();) {
				/*
				 * ResultSetオブジェクトから結果を取得
				 */
				while (rs.next()) {
					int id = rs.getInt(1); // or rs.getInt("ID")
					String name = rs.getString("NAME");
					int price = rs.getInt("PRICE");
					System.out.printf("ID:%3d, NAME: %s, price: %5d\n", id, name, price);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
