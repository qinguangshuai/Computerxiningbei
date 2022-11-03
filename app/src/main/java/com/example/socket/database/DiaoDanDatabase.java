package com.example.socket.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @date 2021/9/24 15:08
 */
@Database(entities = {DiaoDan.class}, version = 1, exportSchema = false)
public abstract class DiaoDanDatabase extends RoomDatabase {
    public abstract DiaodanDAO DiaodanDAO();
    private static volatile DiaoDanDatabase INSTANCE;
    static DiaoDanDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DiaoDanDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    DiaoDanDatabase.class, "Diaodan_Database")
                                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
