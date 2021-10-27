package br.com.erick.agenda;

import android.app.Application;

import androidx.room.Room;

import br.com.erick.agenda.dao.AlunoDAO;
import br.com.erick.agenda.database.AgendaDatabase;
import br.com.erick.agenda.database.dao.RoomAlunoDAO;
import br.com.erick.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {

        AgendaDatabase database = Room.databaseBuilder(this, AgendaDatabase.class, "agenda.db").allowMainThreadQueries().build();
        RoomAlunoDAO dao = database.getRoomAlunoDAO();

        dao.salva(new Aluno("Erick Spinelli Pimentel", "81998980445", "erick@gmail.com"));
        dao.salva(new Aluno("Silvia Spinelli de Souza Menezes Pimentel", "81997867761", "silvia@gmail.com"));
        dao.salva(new Aluno("Antonio Albino Pimentel Junior", "81997614471", "antonio@gmail.com"));
    }
}
