package com.dp.mingmi;

/**
 * Created by zhangmingmi on 16/10/12.
 */
public class Teacher {
    private String teacherName;
    private int teacherAge;
    private boolean Status;

    public Teacher(String teacherName, int teacherAge, boolean status) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        Status = status;
    }

    public String getTearcherName() {
        return teacherName;
    }

    public void setTearcherName(String tearcherName) {
        this.teacherName = tearcherName;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tearcherName='" + teacherName + '\'' +
                ", teacherAge=" + teacherAge +
                ", Status=" + Status +
                '}';
    }

    public Teacher() {
    }
}
