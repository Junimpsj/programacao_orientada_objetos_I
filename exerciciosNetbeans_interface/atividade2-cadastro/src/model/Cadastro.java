package model;

import java.util.ArrayList;

/**
 * Model do formulario de cadastro.
 * Armazena dados pessoais, cursos selecionados e motivo de interesse.
 */
public class Cadastro {

    private String nome;
    private String telefone;
    private String endereco;
    private String cidade;
    private String uf;
    private String email;
    private String sexo;
    private ArrayList<String> cursos;
    private String motivo;

    /**
     * @param nome      nome completo do usuario
     * @param telefone  telefone de contato
     * @param endereco  endereco residencial
     * @param cidade    cidade do usuario
     * @param uf        sigla do estado (UF)
     * @param email     endereco de e-mail
     * @param sexo      sexo informado (Feminino ou Masculino)
     * @param cursos    lista de cursos selecionados
     * @param motivo    texto com o motivo de interesse nos cursos
     */
    public Cadastro(String nome, String telefone, String endereco, String cidade,
                    String uf, String email, String sexo,
                    ArrayList<String> cursos, String motivo) {
        this.nome      = nome;
        this.telefone  = telefone;
        this.endereco  = endereco;
        this.cidade    = cidade;
        this.uf        = uf;
        this.email     = email;
        this.sexo      = sexo;
        this.cursos    = cursos;
        this.motivo    = motivo;
    }

    /** @return nome do usuario */
    public String getNome()     { return nome; }

    /** @return telefone do usuario */
    public String getTelefone() { return telefone; }

    /** @return endereco do usuario */
    public String getEndereco() { return endereco; }

    /** @return cidade do usuario */
    public String getCidade()   { return cidade; }

    /** @return sigla do estado */
    public String getUf()       { return uf; }

    /** @return e-mail do usuario */
    public String getEmail()    { return email; }

    /** @return sexo informado */
    public String getSexo()     { return sexo; }

    /** @return lista de cursos selecionados */
    public ArrayList<String> getCursos() { return cursos; }

    /** @return motivo de interesse nos cursos */
    public String getMotivo()   { return motivo; }
}
