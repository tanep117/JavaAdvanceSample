package chap12.CRUDsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {

		String[] goods = {
				"コーラ",
				"USB",
				"傘",
				"お茶"
		};

		int[] prices = {
				100,
				2000,
				500,
				100
		};

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
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO goods_table(name, price) VALUES(?,?)");) {

				for(int i=0;i<goods.length; i++) {
					pstmt.setString(1, goods[i]);
					pstmt.setInt(2, prices[i]);
					pstmt.executeUpdate();
					System.out.println(i+"件目のデータの挿入に成功しました。");
				}


		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
