package com.sj.base_database.bean;


public class AccountSort {
    public String name;        //记录日期
    public String details;       //账单类

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details == null ? "" : details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
