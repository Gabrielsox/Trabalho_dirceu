/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import bo.BOCategoria;
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
import to.TOCategoria;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("categoria")
public class ServiceCategoria {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceCategoria() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOCategoria inserir(TOCategoria categoria) throws Exception {
        BOCategoria.inserir(categoria);
        return categoria;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOCategoria alterar(TOCategoria categoria) throws Exception {

        BOCategoria.alterar(categoria);

        return categoria;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOCategoria> obterCliente() throws Exception {
        return BOCategoria.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOCategoria obterCliente(@PathParam("id") int id) throws Exception {
        return BOCategoria.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BOCategoria.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
