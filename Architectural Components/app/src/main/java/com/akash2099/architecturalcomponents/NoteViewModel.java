package com.akash2099.architecturalcomponents;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository; // repository instance
    private LiveData<List<Note>> allNotes; // LiveData of notes

    public NoteViewModel(@NonNull Application application) {
        super(application);
        // Get the instance of the repository
        repository = new NoteRepository(application);
        // Get allNotes from repository instance
        allNotes = repository.getAllNotes();
    }
    // Accessing repository exposed API end points
    public void insert(Note note) {
        repository.insert(note);
    }
    public void update(Note note) {
        repository.update(note);
    }
    public void delete(Note note) {
        repository.delete(note);
    }
    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
