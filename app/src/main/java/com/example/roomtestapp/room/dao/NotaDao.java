package com.example.roomtestapp.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomtestapp.entities.Nota;

import java.util.List;

/**
 * getNotes, para extrair todas as notas salvas no banco de dados. Nesse caso, haverá apenas um.
 *
 * getNota, para extrair uma nota do seu ID.
 *
 * addNota, para criar uma nova anotação no banco de dados.
 *
 * deleteNote, para excluir uma nota do banco de dados.
 *
 * updateNote, para atualizar uma observação que já existe no banco de dados.
 */

@Dao
public interface NotaDao {

    @Query("SELECT * FROM nota")
    List<Nota> getNotas();

    @Query("SELECT * FROM nota WHERE id LIKE :uuid")
    Nota getNota(String uuid);

    @Insert
    void addNota(Nota book);

    @Delete
    void deleteNota(Nota book);

    @Update
    void updateNota(Nota book);

}

