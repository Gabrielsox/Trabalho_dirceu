/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOReceber;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOReceber;


/**
 *
 * @author gabri
 */
public class BOReceber {
    public static void inserir(TOReceber u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOReceber.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOReceber.excluir(c, id);
        }
    }

    public static void alterar(TOReceber u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOReceber.alterar(c, u);
        }
    }

    public static TOReceber obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOReceber.obter(c, id);
        }
    }

    public static List<TOReceber> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOReceber.lista(c, filtro);
        }
    }

}
