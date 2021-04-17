package com.lrm.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_files")
public class File1 {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String nickname;

    private String avatar;

    private String fileName;

    private Date createTime;


    @Override
    public String toString() {
        return "File1{" +
                "id=" + id +
                ", userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
