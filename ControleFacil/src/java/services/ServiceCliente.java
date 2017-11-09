/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bo.BOCliente;
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
import to.TOCliente;
import to.TORetorno;
import javax.ws.rs.Consumes;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("cliente")
public class ServiceCliente {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceCliente() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOCliente inserir(TOCliente cliente) throws Exception {
        BOCliente.inserir(cliente);
        return cliente;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOCliente alterar(TOCliente cliente) throws Exception {

        BOCliente.alterar(cliente);

        return cliente;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOCliente> obterCliente() throws Exception {
        return BOCliente.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOCliente obterCliente(@PathParam("id") int id) throws Exception {
        return BOCliente.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BOCliente.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
