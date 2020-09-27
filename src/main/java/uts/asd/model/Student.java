/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fuxin Bi
 */
public class Student implements Serializable
{
    private int Id;
    private String FullName;
    private Date DOB;
    private String Email;
    private String Address;
    private int Phone;
    private String Title;
    private String Password;

    public Student() {
        
    }
    public Student(int Id, String FullName, Date DOB, String Email, String Address, int Phone, String Title, String Password) {
        this.Id = Id;
        this.FullName = FullName;
        this.DOB = DOB;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.Title = Title;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
   

    
    
