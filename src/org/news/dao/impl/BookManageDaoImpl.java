package org.news.dao.impl;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.news.dao.BaseDao;
import org.news.dao.BookManageDao;
import org.news.entity.BookManage;

/**
 * @author think
 */
public class BookManageDaoImpl extends BaseDao implements BookManageDao {

	@Override
	public List<BookManage> getAll() throws SQLException {
		connection=super.getConnection();
		String sql="select*from tb_bookmanage order by b_time desc ";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		BookManage bookManage=null;
		List<BookManage> list=new ArrayList<BookManage>();
		while (resultSet.next()) {
			bookManage=new BookManage();
			bookManage.setId(resultSet.getInt("b_id"));
			bookManage.setName(resultSet.getString("b_name"));
			bookManage.setAuthor(resultSet.getString("b_author"));
			bookManage.setTime(resultSet.getDate("b_time"));
			bookManage.setType(resultSet.getInt("b_type"));
			list.add(bookManage);
		}
		//¹Ø±ÕÎÄµµÁ÷
		super.closeAll(connection, preparedStatement, resultSet);
		return list;
	}

	@Override
	public int insertBook(BookManage bookManage) {
		String sql="insert into tb_bookmanage (b_name,b_author,b_time,b_type)value(?,?,?,?)";
		int result = 0;
		result = this.executeUpdate(sql, bookManage.getName(),
				bookManage.getAuthor(),
				bookManage .getTime(),
				bookManage.getType());

		return result;
	}

	@Override
	public int del(int id) {
		String sql="delete from tb_bookmanage where b_id=?";
		int result = 0;
		result = this.executeUpdate(sql,id);

		return result;
	}


}
