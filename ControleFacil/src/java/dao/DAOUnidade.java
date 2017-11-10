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
import to.TOUnidade;


/**
 *
 * @author gabri
 */
public class DAOUnidade {
    
    public static void inserir(Connection c, TOUnidade t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into unidadeMedida (nomeUnidade) ");
        sql.append(" values (?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getNomeUnidade());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from unidadeMedida ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOUnidade obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeUnidade from unidadeMedida ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOUnidade(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOUnidade t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update unidadeMedida ");
        sql.append(" set nomeUnidade = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),           
                t.getNomeUnidade(), t.getId());
    }

    public static List<TOUnidade> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeUnidade from unidadeMedida ");
        sql.append(" order by nomeUnidade ");

        List<TOUnidade> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOUnidade(rs));
            }
        }
        return l;
    }
    
}
