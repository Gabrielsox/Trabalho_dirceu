/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOFornecedor;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOFornecedor;


/**
 *
 * @author gabri
 */
public class BOFornecedor {
    public static void inserir(TOFornecedor u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOFornecedor.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOFornecedor.excluir(c, id);
        }
    }

    public static void alterar(TOFornecedor u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOFornecedor.alterar(c, u);
        }
    }

    public static TOFornecedor obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOFornecedor.obter(c, id);
        }
    }

    public static List<TOFornecedor> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOFornecedor.lista(c, filtro);
        }
    }

    
}
