package com.example.himanshu.bpit.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {EntityNode.class},version = 1,exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {
    private static ChatDatabase chatInstance;
    public abstract DaoChatNode daoChatNode();
    public static synchronized ChatDatabase getChatInstance(Context context)
    {   if(chatInstance==null)
    {
        chatInstance=Room.databaseBuilder(context.getApplicationContext(),ChatDatabase.class,"node_database")
                .fallbackToDestructiveMigration()
                .build();}
    return chatInstance;
    }
//    public  static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//        }
//    };
}
