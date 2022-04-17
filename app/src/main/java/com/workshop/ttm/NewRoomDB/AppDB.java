package com.workshop.ttm.NewRoomDB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={TaskDB.class}, version=1)
public abstract class AppDB extends RoomDatabase {
    public abstract TaskDao taskDao();
    public static AppDB INSTANCE;
    public static AppDB getDbInstance(Context context){
      if(INSTANCE==null){
          INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDB.class,"Task_DB")
                  .allowMainThreadQueries().build();
      }
      return INSTANCE;
    }
    public TaskDao taskDao;

}
