/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.modelo;

/**
 *
 * @author u18206
 */
public class Filme
{
    private Long id;
    private String filme;
    private String sinopse;
    private String genero;
    private Integer duracao;
    private String trailer;

    public Filme(Long id, String filme, String sinopse, String genero, Integer duracao, String trailer) 
    {
      this.id = id;
      this.filme = filme;
      this.sinopse = sinopse;
      this.genero = genero;
      this.duracao = duracao;
      this.trailer = trailer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws Exception {
        if (id <= 0)
            throw new Exception("ID inválido!");
        
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) throws Exception {
        if (filme == null)
            throw new Exception("Nome de filme inválido!");
            
        this.filme = filme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) throws Exception {
        if (sinopse == null)
            throw new Exception("Sinopse inválida!");
        
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws Exception {
        if (genero == null)
            throw new Exception("Gênero inválido!");
        
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) throws Exception {
        if (duracao <= 0)
            throw new Exception("Duração inválida!");
        
        this.duracao = duracao;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) throws Exception {
        if (trailer == null)
            throw new Exception("Trailer inválido!");
        
        this.trailer = trailer;
    }
    
    public String toString()
    {
            return "ID:      " + this.id      + "\n" +
                   "Filme:   " + this.filme   + "\n" +
                   "Sinopse: " + this.sinopse + "\n" +
                   "Gênero:  " + this.genero  + "\n" +
                   "Duração: " + this.duracao + "\n" +
                   "Trailer: " + this.trailer;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Filme))
            return false;

        Filme c = (Filme)obj;

        if (!this.id.equals(c.id))
                return false;

        if (!this.filme.equals(c.filme))
                return false;

        if (!this.sinopse.equals(c.sinopse))
                return false;

        if (!this.genero.equals(c.genero))
                return false;

        if (this.duracao != c.duracao)
                return false;
        
        if (!this.trailer.equals(c.trailer))
                return false;

        return true;
    }

    public int hashCode()
    {
            int ret = 7;

            ret *= 2 + new Long(this.id).hashCode();
            ret *= 2 + this.filme.hashCode();
            ret *= 2 + this.sinopse.hashCode();
            ret *= 2 + this.genero.hashCode();
            ret *= 2 + new Integer(this.duracao).hashCode();
            ret *= 2 + this.trailer.hashCode();

            return ret;
    }

    public Filme (Filme m) throws Exception
    {
            this.id = m.id;
            this.filme = m.filme;
            this.sinopse = m.sinopse;
            this.genero = m.genero;
            this.duracao = m.duracao;
            this.trailer = m.trailer;
    }

    public Object clone()
    {
        Filme ret = null;

        try
        {
            ret = new Filme(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}