package com.example.roomtestapp.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomtestapp.room.dao.NotaDao;
import com.example.roomtestapp.entities.Nota;

@Database(entities = {Nota.class}, version = 1)
public abstract class NotaDatabase extends RoomDatabase {

    public abstract NotaDao getNotaDao();
}
