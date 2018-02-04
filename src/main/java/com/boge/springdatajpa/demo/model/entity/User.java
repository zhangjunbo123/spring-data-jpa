package com.boge.springdatajpa.demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//注意：这里必须使用User.，不然不会识别
//这个就是JPQL查询，由@NamedQuery定义，其特征与原生SQL语句类似，并且完全面向对象，通过类名和属性访问，而不是表名和表的属性。
@NamedQuery(name = "User.findById", query = "select u from User u where u.id >= ?1")
public class User {
    private int id;
    private String name;
    private String password;
    private String tel;

    @Column
    private String remark;

    @Column(name = "user_name")
    private String userName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 18)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 18)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }
}
