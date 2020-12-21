package ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	static Reader rd = null;
	static SqlMapClient smc = null;
	static {

		try {
			// 1. Read and execute the iBatis environment configuration file
			// ()sqlMapConfig.xml).
			// Class LprodIbatisTest copy // Environment setting
			// 1-1. Setting the character encoding character set
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			// 1-2. Read the configuration file.
			rd = Resources.getResourceAsReader("ibatis/config/sqlMapConfig.xml");

			// 1-3. After completing the actual environment setting using the reader object
			// read above
			// Create an object that can be executed by calling an SQL statement.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			// 환경설정 끝.~~~~~~~~~~

		} catch (IOException e) {
			e.printStackTrace();
		}

		// factory delete?? close or not close????
		finally {
			if (rd != null) {
				try {
					rd.close(); // ��ü �ݱ�
				} catch (IOException e2) {
					// TODO: handle exception
				}
			} // if
		} // finally
	}// static

	// Return after static (above method) is finished.
	// Call the environment setting value set according to the case received from
	// dao

	public static SqlMapClient getSqlMapClient() {
		return smc;
	}

}// class
