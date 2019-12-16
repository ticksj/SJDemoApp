package com.sj.a_4_contentprovider_b.db;

public interface DBTables {
    String DB_NAME = "db.sqlite";
    int DB_VERSION = 1;


    String D_TABLE = "dtable";
    String TABLE_DATA = "create table "+ D_TABLE +"(" +
            "id integer primary key autoincrement," +
            "d1 varchar(100)," +
            "d2 varchar(100)"+
            ")";
}
