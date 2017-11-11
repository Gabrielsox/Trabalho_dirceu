/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOCategoria;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOCategoria;


/**
 *
 * @author gabri
 */
public class BOCategoria {
    public static void inserir(TOCategoria u) throws Exception {
        try (Connection c = Data.openConnection()) {

            DAOCategoria.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOCategoria.excluir(c, id);
        }
    }

    public static void alterar(TOCategoria u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOCategoria.alterar(c, u);
        }
    }

    public static TOCategoria obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOCategoria.obter(c, id);
        }
    }

    public static List<TOCategoria> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOCategoria.lista(c, filtro);
        }
    }

}
