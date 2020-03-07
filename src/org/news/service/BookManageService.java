package org.news.service;

import java.sql.SQLException;
import java.util.List;

import org.news.entity.BookManage;

/**
 * @author think
 */
public interface BookManageService {
    /**
     * �������ͼ��
     * @return
     * @throws SQLException
     */
	List<BookManage> getAll() throws SQLException;

    /**
     * ����ͼ����Ϣ����Ӱ������
     * @param bookManage
     * @return
     */
	int insertBook(BookManage bookManage);

    /**
     * ����ָ��IDɾ��ͼ����Ϣ �����Ƿ�ɹ�
     * @param id
     * @return
     */
	int del(int id);
}
