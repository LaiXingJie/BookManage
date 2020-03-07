package org.news.dao;

import java.sql.SQLException;
import java.util.List;

import org.news.entity.BookManage;

/**
 * @author think
 */
public interface BookManageDao {
	/**
	 * �������ͼ��
	 *
	 * @return List<BookManage>
	 * @throws SQLException SQLException
	 */
	List<BookManage> getAll() throws SQLException;

    /**
     * ����ͼ����Ϣ����Ӱ������
     * @param bookManage
     * @return ���ݿ��޸ĵ�����
     */
	int insertBook(BookManage bookManage);

    /**
     * ����ָ��IDɾ��ͼ����Ϣ ����int����
     * @param id �������
     * @return ���ݿ��޸ĵ�����
     */
	int del(int id);
}
