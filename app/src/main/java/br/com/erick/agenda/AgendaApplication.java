package br.com.erick.agenda;

import android.app.Application;

import br.com.erick.agenda.dao.AlunoDAO;
import br.com.erick.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();

        dao.salva(new Aluno("Erick Spinelli Pimentel", "81998980445", "erick@gmail.com"));
        dao.salva(new Aluno("Silvia Spinelli de Souza Menezes Pimentel", "81997867761", "silvia@gmail.com"));
        dao.salva(new Aluno("Antonio Albino Pimentel Junior", "81997614471", "antonio@gmail.com"));
    }
}
