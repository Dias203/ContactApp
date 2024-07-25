package com.mastercoding.contactsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//Biểu diễn cơ sở dữ liệu và cung cấp phương thức để truy cập DAO.
@Database(entities = {Contacts.class},version = 1)
public abstract class ContactDatabase extends RoomDatabase{

    //B1: liên kết database với DAO
    public abstract ContactDAO getContactDAO();

    //Step2: Singleton Pattern
    //singleton đảm bảo rằng chỉ có một instance of database(trường hợp của CSDL) tồn tại trong suốt vòng đời của ứng dụng
    //chu kỳ tối ưu hóa việc sử dụng tài nguyên
    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context){
        //check if there is any existing instance of the database during the life cycle of the app
        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    "contacts_db").
                    fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }




}
