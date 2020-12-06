package com.akash2099.architecturalcomponents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
// Step 2
// Dao can only be an (interface) : creation | or | (abstract class) : access
// We can directly interact with the database using DAO (Data Access Object)
@Dao
public interface NoteDao {
    // Different operation in Entity
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT* FROM note_table ORDER BY priority_column DESC")
    LiveData<List<Note>> getAllNotes();
}
