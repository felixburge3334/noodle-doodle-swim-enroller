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
public class Event implements Serializable
{
    private int Id;
    private String Name;
    private Date Date;
    private String Description;
    private boolean Visibility;

    public Event()
    {
        
    }

    public Event(int Id, String Name, Date Date, String Description, boolean Visibility) 
    {
        this.Id = Id;
        this.Name = Name;
        this.Date = Date;
        this.Description = Description;
        this.Visibility = Visibility;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isVisibility() {
        return Visibility;
    }

    public void setVisibility(boolean Visibility) {
        this.Visibility = Visibility;
    }
    
    
    
}
            
