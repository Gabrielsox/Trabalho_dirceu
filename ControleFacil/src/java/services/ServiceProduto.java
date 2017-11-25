/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import bo.BOProduto;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import to.TORetorno;
import javax.ws.rs.Consumes;
import to.TOProduto;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("produto")
public class ServiceProduto {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceProduto() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOProduto inserir(TOProduto produto) throws Exception {
        BOProduto.inserir(produto);
        return produto;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOProduto alterar(TOProduto produto) throws Exception {

        BOProduto.alterar(produto);

        return produto;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOProduto> obterProduto() throws Exception {
        return BOProduto.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOProduto obter(@PathParam("id") int id) throws Exception {
        return BOProduto.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BOProduto.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
