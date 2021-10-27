package br.com.erick.agenda.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.com.erick.agenda.database.dao.AlunoDAO;
import br.com.erick.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 2, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context){
        return Room.databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS).addMigrations(new Migration(1,2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
            }
        }).allowMainThreadQueries().build();
    }
}
