package com.workshop.ttm.RoomDatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Task.class,version =1)
public abstract class TaskDatabase extends RoomDatabase {
    private static TaskDatabase instance;
    public abstract TaskDao taskDao();

    public static synchronized TaskDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class, "task_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void, Void>{
        private TaskDao taskDao;
        private PopulateDbAsyncTask(TaskDatabase db){
            taskDao=db.taskDao();
        }
        @Override
            protected Void doInBackground(Void... Voids) {
            taskDao.insert(new Task("Do Something","anything which is productive"));
            taskDao.insert(new Task("Wash Clothes","tonns of clothes left"));
            taskDao.insert(new Task("Meeting","meeting with someone"));
            taskDao.insert(new Task("Pay for Dinner","pay them for dinner by night"));
            taskDao.insert(new Task("Ask for a Raise","this is the high time"));
            taskDao.insert(new Task("Turn off Gas Stove","milk is boiling"));
            return null;
        }
    }
}
