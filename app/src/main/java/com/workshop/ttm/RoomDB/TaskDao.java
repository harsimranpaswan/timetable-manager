package com.workshop.ttm.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(TaskDB task);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table")
    LiveData<List<TaskDB>> getTasks();

    @Query("SELECT * FROM task_table WHERE task_table.taskid==:id")
    LiveData<TaskDB> get(long id);

    @Update
    void update(TaskDB task);

    @Delete
    void delete(TaskDB task);
}
