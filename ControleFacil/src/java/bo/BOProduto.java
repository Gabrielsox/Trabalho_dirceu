/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOProduto;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOProduto;


/**
 *
 * @author gabri
 */
public class BOProduto {
    public static void inserir(TOProduto u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOProduto.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOProduto.excluir(c, id);
        }
    }

    public static void alterar(TOProduto u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOProduto.alterar(c, u);
        }
    }

    public static TOProduto obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOProduto.obter(c, id);
        }
    }

    public static List<TOProduto> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOProduto.lista(c, filtro);
        }
    }
    
}
