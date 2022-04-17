package com.workshop.ttm.NewRoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskDB {
    @PrimaryKey(autoGenerate = true)
    public int task_id;
    public String title;
    public String task_desc;

}
