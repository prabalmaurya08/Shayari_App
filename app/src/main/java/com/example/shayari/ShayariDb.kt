package com.example.shayari

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [DataEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ShayariDb : RoomDatabase() {

    abstract fun shayariDao(): ShayariDao

    companion object {
        @Volatile
        private var INSTANCE: ShayariDb? = null

        fun getInstance(context: Context): ShayariDb? {
            if (INSTANCE == null) {
                synchronized(ShayariDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ShayariDb::class.java,
                            "shayari_database"
                        )

                            .build()
                    }
                }
            }
            return INSTANCE
        }

//        private val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // Migration logic here
//                database.execSQL("ALTER TABLE shayari_table ADD COLUMN new_column TEXT")
//            }
//        }
    }
}
