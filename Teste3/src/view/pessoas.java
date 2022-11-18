package view;

import javafx.beans.property.SimpleStringProperty;

public class pessoas {

    private final SimpleStringProperty matricula;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty ocupacao;

    pessoas(String matri, String nom, String ocupa)
    {
        
        this.matricula = new SimpleStringProperty(matri);
        this.nome = new SimpleStringProperty(nom);
        this.ocupacao = new SimpleStringProperty(ocupa);

    }

    public String getMatricula()
    {
        return matricula.get();
    }

    public void setMatricula(String matri)
    {
        matricula.set(matri);
    }

    public String getNome()
    {
        return nome.get();
    }

    public void setNome(String nom)
    {
        nome.set(nom);
    }

    public String getOcupacao()
    {
        return ocupacao.get();
    }

    public void setOcupacao(String ocupa)
    {
        ocupacao.set(ocupa);
    }
}
