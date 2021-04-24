package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;

import java.io.Serializable;

public class Course implements Serializable {
    private String departmentId;
    private int cid;
    private String courseid = departmentId+cid;
}