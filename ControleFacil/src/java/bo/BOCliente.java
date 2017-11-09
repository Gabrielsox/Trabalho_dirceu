/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOCliente;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOCliente;


/**
 *
 * @author usuario
 */
public class BOCliente {

    public static void inserir(TOCliente u) throws Exception {
        try (Connection c = Data.openConnection()) {

            // TODO: criptografar senha
            DAOCliente.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOCliente.excluir(c, id);
        }
    }

    public static void alterar(TOCliente u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOCliente.alterar(c, u);
        }
    }

    public static TOCliente obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOCliente.obter(c, id);
        }
    }

    public static List<TOCliente> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOCliente.lista(c, filtro);
        }
    }

}
