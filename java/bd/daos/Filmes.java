/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.daos;

/**
 *
 * @author u18206
 */
public class Filmes
{
    public static boolean cadastrado(int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILME " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar Filme!");
        }

        return retorno;
    }

    public static void incluir(Filme f) throws Exception
    {
        if (f == null)
            throw new Exception ("Filme não fornecido!");

        try
        {
            String sql;

            sql = "INSERT INTO FILME " +
                  "(ID, FILME, SINOPSE, GENERO, DURACAO, TRAILER) " +
                  "VALUES " +
                  "(?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt   (1, f.getId());
            BDSQLServer.COMANDO.setString(2, f.getFilme());
            BDSQLServer.COMANDO.setString(3, f.getSinopse());
            BDSQLServer.COMANDO.setString(4, f.getGenero());
            BDSQLServer.COMANDO.setString(5, f.getDuracao());
            BDSQLServer.COMANDO.setString(6, f.getTrailer());

            BDSQLServer.COMANDO.execute ();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir Filme!");
        }
    }

    public static void excluir(int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "DELETE FROM FILME " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, codigo);

            BDSQLServer.COMANDO.execute();
            BDSQLServer.COMANDO.commit();        
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao excluir Filme!");
        }
    }

    public static void alterar(Filme f) throws Exception
    {
        if (f == null)
            throw new Exception("Filme inválido!");

        if (!cadastrado (f.getId()))
            throw new Exception("Filme inexistente!");

        try
        {
            String sql;

            sql = "UPDATE FILME " +
                  "SET FILME = ? " +
                  ", SINOPSE = ? " +
                  ", GENERO = ? " +
                  ", DURACAO = ? " +
                  ", TRAILER = ?" +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, f.getFilme());
            BDSQLServer.COMANDO.setString(2, f.getSinopse());
            BDSQLServer.COMANDO.setString(3, f.getGenero());
            BDSQLServer.COMANDO.setString(4, f.getDuracao());
            BDSQLServer.COMANDO.setString(5, f.getTrailer());
            BDSQLServer.COMANDO.setInt(6, f.getId());

            BDSQLServer.COMANDO.execute();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de Filme!");
        }
    }

    public static Filme getFilme(int codigo) throws Exception
    {
        Filme f = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILME " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");

            f = new Filme(resultado.getInt   ("ID"),
                          resultado.getString("FILME"),
                          resultado.getString("SINOPSE"),
                          resultado.getString("GENERO"),
                          resultado.getInt   ("DURACAO"));
                          resultado.getString("TRAILER");
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar Filme!");
        }

        return f;
    }

    public static MeuResultSet getFilmes() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILME";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar Filmes!");
        }

        return resultado;
    }
}
