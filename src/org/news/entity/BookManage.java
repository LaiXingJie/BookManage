package org.news.entity;

import java.util.Date;

/**
 * @author :think
 */
public class BookManage {

    /**
     * id ����
     */
    private int id;
    /**
     * name ͼ������
     */

    private String name;
    /**
     * author ����
     */
    private String author;
    /**
     * time ����ʱ��
     */
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * type ͼ�����
     */
    private Integer type;


}
