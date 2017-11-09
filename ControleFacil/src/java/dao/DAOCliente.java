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
import to.TOCliente;

/**
 *
 * @author gabri
 */
public class DAOCliente {

    public static void inserir(Connection c, TOCliente t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into cliente (nome, email, endereco, telefone,observacao) ");
        sql.append(" values (?, ?, ?, ?, ?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getNome(), t.getEmail(), t.getEndereco(), t.getTelefone(), t.getObservacao());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from cliente ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOCliente obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, email, endereco, telefone, observacao from cliente ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOCliente(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOCliente t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update cliente ");
        sql.append(" set nome = ?, email = ?, endereco = ?, telefone = ?, observacao = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),           
                t.getNome(), t.getEmail(), t.getEndereco(), t.getTelefone(), t.getObservacao(),t.getId());
    }

    public static List<TOCliente> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, email, endereco, telefone, observacao from cliente ");
        sql.append(" order by nome ");

        List<TOCliente> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOCliente(rs));
            }
        }
        return l;
    }

}
