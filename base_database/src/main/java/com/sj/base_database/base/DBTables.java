package com.sj.base_database.base;

public interface DBTables {
    String DB_NAME = "db.sqlite";
    int DB_VERSION = 1;


    String TABLE_ACCOUNT = "account";
    String ACCOUNT_SQL = "create table "+TABLE_ACCOUNT+"(" +
            "id integer primary key autoincrement," +
            "date varchar(20)," +
            "sort varchar(10)," +
            "detail varchar(10)," +
            "sum varchar(10)," +
            "source varchar(10)," +
            "income integer," +
            "type varchar(10)," +
            "reason varchar(10)," +
            "remark varchar(60)" +
            ")";

    String TABLE_ACCOUNT_SORT = "sort";
    String ACCOUNT_SORT_SQL = "create table "+TABLE_ACCOUNT_SORT+"(" +
            "name varchar(10) primary key," +
            "details varchar(100)" +
            ")";
    String TABLE_ACCOUNT_DETAIL = "detail";
    String ACCOUNT_DETAIL_SQL = "create table "+TABLE_ACCOUNT_DETAIL+"(" +
            "name varchar(10) primary key," +
            "budget varchar(100)" +
            ")";
}
