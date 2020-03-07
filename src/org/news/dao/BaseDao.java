package org.news.dao;

/*
 * 操作数据库的通用类
 * @author Think
 *
 */

import java.sql.*;

public class BaseDao {

	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;

	protected Connection getConnection() {
		
		try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanage?useUnicode=true&amp;characterEncoding=utf-8", "root","123456");
            } catch (Exception e) {
                e.printStackTrace();
            }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	// 2、关闭所有资源

	protected void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 3、增、删、改通用方法
	 * @param sql  SQL语句
     * @param param 数组
 	 */
	protected int executeUpdate(String sql, Object...param) {

		// 影响行数
		int num = 0;
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 为参数进行赋值
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					preparedStatement.setObject(i + 1, param[i]);
				}
			}
			// 执行SQL语句
			num = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(connection, preparedStatement, null);
		}
		return num;
	}

	/**
	 * 执行查询操作 备注：此方法适用于纯查询使用，若是输入加查询需要另外设计
	 * 
	 * @param sql 语句
	 * @return resultSet 返回集合
	 */
	public ResultSet executeQuery(String sql,Object...param) {
		
		connection = this.getConnection();
		try {
			// 发送SQL语句
			preparedStatement = connection.prepareStatement(sql);
			//参数进行赋值
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					preparedStatement.setObject(i + 1, param[i]);
				}
			}
			// 返回结果集
			resultSet = preparedStatement.executeQuery();
			
		} catch (Exception e) {
            // 关闭所有连接
			closeAll(connection, preparedStatement, resultSet);

			System.out.println("发生异常:\n" + e.getMessage());
			
		}
		return resultSet;
	}
}
