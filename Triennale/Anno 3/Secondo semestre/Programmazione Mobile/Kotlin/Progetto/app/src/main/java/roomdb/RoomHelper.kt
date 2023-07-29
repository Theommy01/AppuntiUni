package roomdb

import android.content.Context
import androidx.room.Room

class RoomHelper {
    fun getDatabaseObject(appContext: Context): LocalDB {
        return Room.databaseBuilder(appContext, LocalDB::class.java, "LocalDatabase")
            .allowMainThreadQueries()
            .createFromAsset("app.db")
            .build()
    }

    /*
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("app.db")
            .build()
     */
}