package com.example.sem14;

import androidx.annotation.NonNull;

public class Task {

    private String task_name;
    private String task_desc;
    private String creator;
    private String id;
    private String progreso;

public  Task(){}

    public Task(String task_name, String task_desc, String creator, String id,String progreso) {
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.creator = creator;
        this.id = id;
        this.progreso = progreso;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public void setId(String id) {
        this.id = id;

    }


    @NonNull
    @Override
    public String toString() {
        return this.task_name+" :"+"\n"+this.task_desc+"\n";
    }
}
