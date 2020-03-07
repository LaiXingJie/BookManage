package org.news.dao;

import java.sql.SQLException;
import java.util.List;

import org.news.entity.BookManage;

/**
 * @author think
 */
public interface BookManageDao {
	/**
	 * 获得所有图书
	 *
	 * @return List<BookManage>
	 * @throws SQLException SQLException
	 */
	List<BookManage> getAll() throws SQLException;

    /**
     * 新增图书信息返回影响行数
     * @param bookManage
     * @return 数据库修改的行数
     */
	int insertBook(BookManage bookManage);

    /**
     * 根据指定ID删除图书信息 返回int类型
     * @param id 表格主键
     * @return 数据库修改的行数
     */
	int del(int id);
}
