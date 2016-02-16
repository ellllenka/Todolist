package com.todolist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by elena on 06.02.16.
 */
@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String actionName;
    private Date date;
    private String note;
    private Boolean isMade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getIsMade() {
        return isMade;
    }

    public void setIsMade(Boolean isMade) {
        this.isMade = isMade;
    }

    public Action(String actionName, Date date, String note) {
        this.actionName = actionName;
        this.date = date; //????
        this.note = note;
        this.isMade = false;
    }

    public Action(){}
}
