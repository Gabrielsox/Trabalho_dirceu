/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fw.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import to.TODespesa;

/**
 *
 * @author gabri
 */
public class DAODespesa {

    public static void inserir(Connection c, TODespesa t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into despesa (descricao, dataDespesa, valor, observacao) ");
        sql.append(" values (?, now(), ?, ? ) ");

        Data.executeUpdate(c, sql.toString(),
                t.getDescricao(), t.getDataDespesa(), t.getValor(), t.getObservacao());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from despesa ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TODespesa obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, descricao, dataDespesa, valor, observacao from despesa ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TODespesa(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TODespesa t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update despesa ");
        sql.append(" set descricao = ?, dataDespesa = ?, valor = ?, observacao = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),
                Data.executeUpdate(c, sql.toString(),
                        t.getDescricao(), t.getDataDespesa(), t.getValor(), t.getObservacao()));
    }

    public static List<TODespesa> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, descricao, dataDespesa, valor, observacao from despesa ");
        sql.append(" order by descricao ");

        List<TODespesa> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TODespesa(rs));
            }
        }
        return l;
    }

}
