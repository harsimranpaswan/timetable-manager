package com.workshop.ttm.RoomDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int taskid;
    private String title;
    private String desc;

    public Task(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getTaskid() {
        return taskid;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
