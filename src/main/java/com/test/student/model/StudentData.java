/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

/**
 *
 * @author kalyani
 */
public class StudentData {

    public int id;
    private String name;
    private long phone;
    public int department_id;
    public int d_no;

    public StudentData(int id, String name, long phone, int department_id, int d_no) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.department_id = department_id;
        this.d_no = d_no;
    }

    public void displayStudent() {
        System.out.println("Student_ID    Student_Name      MObile_Number");
        System.out.println(" " + id + "           " + name + "            " + phone);
    }

}
