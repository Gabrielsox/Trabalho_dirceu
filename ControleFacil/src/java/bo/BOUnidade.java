/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import dao.DAOUnidade;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOUnidade;


/**
 *
 * @author gabri
 */
public class BOUnidade {
    
    public static void inserir(TOUnidade u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOUnidade.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOUnidade.excluir(c, id);
        }
    }

    public static void alterar(TOUnidade u) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOUnidade.alterar(c, u);
        }
    }

    public static TOUnidade obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOUnidade.obter(c, id);
        }
    }

    public static List<TOUnidade> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOUnidade.lista(c, filtro);
        }
    }

    
}
