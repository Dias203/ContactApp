package com.mastercoding.contactsmanagerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//biểu diễn một bản ghi dữ liệu trong cơ sở dữ liệu
@Entity(tableName = "contacts_table")
public class Contacts {

    @ColumnInfo(name = "contact_id")//chỉ định tên cột
    @PrimaryKey(autoGenerate = true)//có nghĩa là SQL sẽ tự động gán các ID duy nhất cho các bản ghi mới
    private int id;

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    public Contacts( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contacts() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
