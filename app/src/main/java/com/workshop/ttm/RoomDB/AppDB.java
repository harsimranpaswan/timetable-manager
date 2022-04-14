package com.workshop.ttm.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={TaskDB.class}, version=1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {
    public static final int NUMBER_OF_THREADS=4;
    private static volatile AppDB INSTANCE;
    public static final ExecutorService dbExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static final RoomDatabase.Callback myCallback=
            new RoomDatabase.Callback(){
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    dbExecutor.execute(()->{
                        TaskDao taskDao=INSTANCE.taskDao();
                        taskDao.deleteAll();
                    });
                }
            };
    public TaskDao taskDao;

    public static AppDB getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (TaskDB.class){
                if(INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, "Task Database")
                            .addCallback(myCallback).build();
                }
            }
        }
        return  INSTANCE;
    }
    public abstract TaskDao taskDao();
}
