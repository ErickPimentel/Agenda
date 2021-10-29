package br.com.erick.agenda.database;

import static br.com.erick.agenda.database.AgendaMigrations.TODAS_MIGRATIONS;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.com.erick.agenda.database.converter.ConversorCalendar;
import br.com.erick.agenda.database.dao.AlunoDAO;
import br.com.erick.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 4, exportSchema = false)
@TypeConverters({ConversorCalendar.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .addMigrations(TODAS_MIGRATIONS)
                .allowMainThreadQueries().build();
    }
}
