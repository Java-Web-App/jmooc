package me.jcala.jmooc.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id

    @Column(nullable = false,length = 40)
    private String name;//用户名

    @Column(nullable = false,length = 32)
    private String password;//密码

    @Column(nullable = false,columnDefinition="tinyint default 1")
    private int type;//类型。1：学生，2：老师，3：管理员

    @Column(columnDefinition="tinyint default 1")
    private int age;//年龄

    @Column(nullable = false,name = "avatar_url",columnDefinition="varchar(40) default '/img/default.png'")
    private String avatarUrl;//头像

    @Column(nullable = false,columnDefinition="tinyint default 1")//1: 正常; 0:冻结
    private boolean status;//状态：正常，冻结

    @Column(name = "exercise_collection")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<Exercise> exerciseCollection;//收藏的习题

    @Column(name = "exercise_error")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<Exercise> exerciseError;//错误的习题

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Exercise> getExerciseCollection() {
        return exerciseCollection;
    }

    public void setExerciseCollection(List<Exercise> exerciseCollection) {
        this.exerciseCollection = exerciseCollection;
    }

    public List<Exercise> getExerciseError() {
        return exerciseError;
    }

    public void setExerciseError(List<Exercise> exerciseError) {
        this.exerciseError = exerciseError;
    }
}
