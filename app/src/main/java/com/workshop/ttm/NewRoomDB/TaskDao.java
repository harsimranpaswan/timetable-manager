package com.workshop.ttm.NewRoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.firestore.auth.User;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM TaskDB")
    List<TaskDB>getAllTasks();

    @Insert
    void insertTask(TaskDB... tasks);

    @Delete
    void deleteTask(TaskDB task);
}
