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
import to.TOFornecedor;

/**
 *
 * @author gabri
 */
public class DAOFornecedor {

    public static void inserir(Connection c, TOFornecedor t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into fornecedor (nomeFornecedor, cnpj, email, endereco, telefone,observacao) ");
        sql.append(" values (?, ?, ?, ?, ?, ?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getNomeFornecedor(), t.getCnpj(), t.getEmail(), t.getEndereco(), t.getTelefone(), t.getObservacao());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from fornecedor ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOFornecedor obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeFornecedor, cnpj, email, endereco, telefone, observacao from fornecedor ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOFornecedor(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOFornecedor t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update fornecedor ");
        sql.append(" set nomeFornecedor = ?, cnpj = ?, email = ?, endereco = ?, telefone = ?, observacao = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),
                t.getNomeFornecedor(), t.getCnpj(), t.getEmail(), t.getEndereco(), t.getTelefone(), t.getObservacao(),t.getId());
    

    
    }

    public static List<TOFornecedor> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeFornecedor, cnpj, email, endereco, telefone, observacao from fornecedor ");
        sql.append(" order by nomeFornecedor ");

        List<TOFornecedor> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOFornecedor(rs));
            }
        }
        return l;
    }

}
