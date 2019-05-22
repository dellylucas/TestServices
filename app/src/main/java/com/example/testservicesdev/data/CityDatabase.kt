package com.example.testservicesdev.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.testservicesdev.Model.Catalog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader


@Database(entities = [Catalog::class], version = 1)
abstract class CityDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        @Volatile
        private var INSTANCE: CityDatabase? = null

        fun getDatabase(
            context: Context//, scope: CoroutineScope
        ): CityDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CityDatabase::class.java,
                    "Test_DB"
                )//.addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

       /* private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)


                  INSTANCE?.let { database ->
                      scope.launch(Dispatchers.IO) {
                          populateDatabase(database.cityDao(),db)
                      }
                  }
            }

            suspend fun populateDatabase(
                cityDao: CityDao,
                db: SupportSQLiteDatabase
            ) {


               // db.execSQL("CREATE TABLE Testeo(id INTEGER PRIMARY KEY, name TEXT)");


                /*  BufferedReader in = new java.io.BufferedReader(res/raw/agregar.csv);
                String reader = "";

                while ((reader = in.readLine()) != null
                ) {
                    String[] RowData = reader . split (","); date = RowData[0];
                    value =   RowData[1];
                    ContentValues values = new ContentValues();
                    values.put(
                        CsvProvider.DATE,
                        date
                    );
                    values.put(CsvProvider.VALUE, value);

                    getContentResolver().insert(
                        CsvProvider.CONTENT_URI,
                        values
                    );
                }
                in . close ();*/
               /*var word = Catalog(1, "Bogota", "1556916483")
                cityDao.insert(word)
                word = Catalog(2, "Medellin", "1556916483")
                cityDao.insert(word)*/
            }
        }*/


    }
}