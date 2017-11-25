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
import to.TOReceber;


/**
 *
 * @author gabri
 */
public class DAOReceber {
    public static void inserir(Connection c, TOReceber t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into receber (id_cliente, descricao, valor, dataVencimento, observacao) ");
        sql.append(" values (?, ?, ?, ?, ? ) ");

        Data.executeUpdate(c, sql.toString(),
                t.getId_cliente(), t.getDescricao(), t.getValor(),t.getDataVencimento(), t.getObservacao());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from receber ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOReceber obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, id_cliente, descricao, valor, dataVencimento, observacao from receber ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOReceber(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOReceber t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update receber ");
        sql.append(" set id_cliente = ?, descricao = ?, valor = ?, dataVencimento = ?, observacao = ? ");
        sql.append(" where id = ? ");
        //t.getDescricao(), t.getDataDespesa(), t.getValor(), t.getObservacao(),t.getId()
        Data.executeUpdate(c, sql.toString(),           
                t.getId_cliente(), t.getDescricao(), t.getValor(),t.getDataVencimento(), t.getObservacao(),t.getId());
    }

    public static List<TOReceber> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, id_cliente, descricao, valor, dataVencimento, observacao from receber ");
        sql.append(" order by id ");
        //date_format(dataDespesa,'%d/%m/%Y')
        List<TOReceber> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOReceber(rs));
            }
        }
        return l;
    }

}
