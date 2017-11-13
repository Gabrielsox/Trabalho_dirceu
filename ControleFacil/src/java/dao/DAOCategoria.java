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
import javafx.scene.control.Alert;
import to.TOCategoria;

/**
 *
 * @author gabri
 */
public class DAOCategoria {

    public static void inserir(Connection c, TOCategoria t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into categoria (nomeCategoria) ");
        sql.append(" values (?) ");

        
        try {
            Data.executeUpdate(c, sql.toString(),
            t.getNomeCategoria());
        } catch (Exception e) {
          System.out.println(e);
        }
        
    

    
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from categoria ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOCategoria obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeCategoria from categoria ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOCategoria(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOCategoria t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update categoria ");
        sql.append(" set nomeCategoria = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),
                t.getNomeCategoria(), t.getId());
    }

    public static List<TOCategoria> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeCategoria from categoria ");
        sql.append(" order by nomeCategoria ");

        List<TOCategoria> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOCategoria(rs));
            }
        }
        return l;
    }
}
