package edu.sunyulster.meldiesestrella.roomwords;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by meldiesestrella on 11/30/18.
 */

@Dao
public interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

}
