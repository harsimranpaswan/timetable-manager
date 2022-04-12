package com.workshop.ttm.RoomDB;

import android.text.format.Time;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task_table")
public class TaskDB {

    @PrimaryKey(autoGenerate = true)
    public long taskid;
    public String task;
    public String desc;
    public Date datecr;
    public Time timecr;
    public Date datede;
    public Time timede;
    public Boolean status;
    public Category category;

    public TaskDB(String task, String desc, Date datecr, Time timecr, Date datede, Time timede, Boolean status, Category category) {
        this.task = task;
        this.desc = desc;
        this.datecr = datecr;
        this.timecr = timecr;
        this.datede = datede;
        this.timede = timede;
        this.status = status;
        this.category = category;
    }

    public long getTaskid() {
        return taskid;
    }

    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDatecr() {
        return datecr;
    }

    public void setDatecr(Date datecr) {
        this.datecr = datecr;
    }

    public Time getTimecr() {
        return timecr;
    }

    public void setTimecr(Time timecr) {
        this.timecr = timecr;
    }

    public Date getDatede() {
        return datede;
    }

    public void setDatede(Date datede) {
        this.datede = datede;
    }

    public Time getTimede() {
        return timede;
    }

    public void setTimede(Time timede) {
        this.timede = timede;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TaskDB{" +
                "taskid=" + taskid +
                ", task='" + task + '\'' +
                ", desc='" + desc + '\'' +
                ", datecr=" + datecr +
                ", timecr=" + timecr +
                ", datede=" + datede +
                ", timede=" + timede +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
