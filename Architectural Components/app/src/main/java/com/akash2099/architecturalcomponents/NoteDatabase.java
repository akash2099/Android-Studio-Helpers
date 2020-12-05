package com.akash2099.architecturalcomponents;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

// Step 3
// This version migration is managed in fallbackToDestructiveMigration
@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    // static since we need a single instance of the database
    private static NoteDatabase instance;

    // below line to access the Dao from repository
    public abstract NoteDao noteDao();

    // synchronized is used to maintain exactly one instance of the Database
    public static synchronized NoteDatabase getInstance(Context context){
        if(instance==null){ // create one instance of the Database if not present
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance; // return the current instance
    }

    // Creating one custom room callback which will be executed onCreate and onOpen Databse
    private static  RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        // Below method can't be used for accessing noteDao below
//        private PopulateDbAsyncTask(NoteDao noteDao) {
//            this.noteDao = noteDao;
//        }

        // Note :
        // Since the async task is called from an instance of the NoteDatabase
        // So I can only access the NoteDatabase methods,
        // In case of NoteRepository since the Async task is called from NoteDao Instance
        // So I can access the methods of NoteDao only/directly

        private PopulateDbAsyncTask(NoteDatabase noteDatabase) {
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Inserting few notes in entity of database
            noteDao.insert(new Note("Title 1", "Description 1", 1));
            noteDao.insert(new Note("Title 2", "Description 2", 2));
            noteDao.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}
