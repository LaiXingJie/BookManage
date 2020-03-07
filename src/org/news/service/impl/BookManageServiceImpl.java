package org.news.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.news.dao.BookManageDao;
import org.news.dao.impl.BookManageDaoImpl;
import org.news.entity.BookManage;
import org.news.service.BookManageService;

/**
 * @author think
 */
public class BookManageServiceImpl implements BookManageService {

	@Override
	public List<BookManage> getAll() throws SQLException {
		BookManageDao bookManageDao=new BookManageDaoImpl();
		return bookManageDao.getAll();
	}

	@Override
	public int insertBook(BookManage bookManage) {
		BookManageDao bookManageDao=new BookManageDaoImpl();
		return bookManageDao.insertBook(bookManage);
	}

	@Override
	public int del(int id) {
		BookManageDao bookManageDao=new BookManageDaoImpl();
		return bookManageDao.del(id);
	}



}
