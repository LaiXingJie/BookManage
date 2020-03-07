package org.news.dao;

/*
 * �������ݿ��ͨ����
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
	// 2���ر�������Դ

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
	 * 3������ɾ����ͨ�÷���
	 * @param sql  SQL���
     * @param param ����
 	 */
	protected int executeUpdate(String sql, Object...param) {

		// Ӱ������
		int num = 0;
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			// Ϊ�������и�ֵ
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					preparedStatement.setObject(i + 1, param[i]);
				}
			}
			// ִ��SQL���
			num = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(connection, preparedStatement, null);
		}
		return num;
	}

	/**
	 * ִ�в�ѯ���� ��ע���˷��������ڴ���ѯʹ�ã���������Ӳ�ѯ��Ҫ�������
	 * 
	 * @param sql ���
	 * @return resultSet ���ؼ���
	 */
	public ResultSet executeQuery(String sql,Object...param) {
		
		connection = this.getConnection();
		try {
			// ����SQL���
			preparedStatement = connection.prepareStatement(sql);
			//�������и�ֵ
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					preparedStatement.setObject(i + 1, param[i]);
				}
			}
			// ���ؽ����
			resultSet = preparedStatement.executeQuery();
			
		} catch (Exception e) {
            // �ر���������
			closeAll(connection, preparedStatement, resultSet);

			System.out.println("�����쳣:\n" + e.getMessage());
			
		}
		return resultSet;
	}
}
