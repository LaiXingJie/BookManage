package org.news.entity;

import java.util.Date;

/**
 * @author :think
 */
public class BookManage {

    /**
     * id 主键
     */
    private int id;
    /**
     * name 图书姓名
     */

    private String name;
    /**
     * author 作者
     */
    private String author;
    /**
     * time 购买时间
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
     * type 图书分类
     */
    private Integer type;


}
