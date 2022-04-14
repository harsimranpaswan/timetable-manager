package com.workshop.ttm.RoomDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepo {
    private final TaskDao taskDao;
    private final LiveData<List<TaskDB>> allTasks;

    public TaskRepo(Application application) {
        AppDB database=AppDB.getDatabase(application);
        this.taskDao = database.taskDao;
        this.allTasks = taskDao.getTasks();
    }
    public LiveData<List<TaskDB>> getAllTasks(){
        return allTasks;
    }

    public void insert (TaskDB task){
        AppDB.dbExecutor.execute(()->taskDao.insertTask(task));
    }

    public LiveData<TaskDB> get(long id){
        return taskDao.get(id);
    }

    public void update(TaskDB task){
        AppDB.dbExecutor.execute(()->taskDao.update(task));
    }

    public void delete(TaskDB task){
        AppDB.dbExecutor.execute(()->taskDao.delete(task));
    }
}
