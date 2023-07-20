package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private double tong;

    public HoaDon(int id, Date date, double tong) {
        this.id = id;
        this.date = date;
        this.tong = tong;
    }

    public HoaDon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTong() {
        return tong;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }
}
