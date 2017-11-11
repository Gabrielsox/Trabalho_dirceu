/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class TOCategoria {

    private int id;
    private String nomeCategoria;

    public TOCategoria(ResultSet rs) throws Exception {
        this.id = rs.getInt("id");
        this.nomeCategoria = rs.getString("nomeCategoria");
    }

    public TOCategoria(){}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeCategoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nomeCategoria the nomeCategoria to set
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
    
    
    
    
    
}
