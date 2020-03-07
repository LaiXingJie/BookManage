package org.news.service;

import java.sql.SQLException;
import java.util.List;

import org.news.entity.BookManage;

/**
 * @author think
 */
public interface BookManageService {
    /**
     * 获得所有图书
     * @return
     * @throws SQLException
     */
	List<BookManage> getAll() throws SQLException;

    /**
     * 新增图书信息返回影响行数
     * @param bookManage
     * @return
     */
	int insertBook(BookManage bookManage);

    /**
     * 根据指定ID删除图书信息 返回是否成功
     * @param id
     * @return
     */
	int del(int id);
}
