package com.lrm.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue
    private Long id;

    private String blogname;

    private Long blogid;

    private  String title;

    private  Long userid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", blogname='" + blogname + '\'' +
                ", blogid=" + blogid +
                ", title='" + title + '\'' +
                ", userid=" + userid +
                '}';
    }
}
