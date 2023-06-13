package com.example.calculadoraimc

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "treino.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "treinos"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TIPO = "tipo"
        private const val COLUMN_DATA_HORA = "data_hora"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE ${Companion.TABLE_NAME} ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_TIPO TEXT, $COLUMN_DATA_HORA TEXT)"
        db.execSQL(createTableQuery)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun adicionarTreino(treino: Treino): Long {
        val values = ContentValues()
        values.put(COLUMN_TIPO, treino.tipo)
        values.put(COLUMN_DATA_HORA, treino.dataHora)

        val db = writableDatabase
        val id = db.insert(TABLE_NAME, null, values)
        db.close()

        return id
    }

    fun obterTodosTreinos(): List<Treino> {
        val treinos = mutableListOf<Treino>()

        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_ID DESC"
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val tipo = cursor.getString(cursor.getColumnIndex(COLUMN_TIPO))
                val dataHora = cursor.getString(cursor.getColumnIndex(COLUMN_DATA_HORA))
                val treino = Treino(tipo, dataHora)
                treinos.add(treino)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return treinos
    }

    fun removerTreino(id: Long) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
    }
}
