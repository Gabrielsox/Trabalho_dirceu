/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;




import bo.BOReceber;
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
import to.TOReceber;

import to.TORetorno;


/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("receber")
public class ServiceReceber {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceReceber() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOReceber inserir(TOReceber receber) throws Exception {
        BOReceber.inserir(receber);
        return receber;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOReceber alterar(TOReceber receber) throws Exception {
        BOReceber.alterar(receber);
        return receber;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOReceber> obterReceber() throws Exception {
        return BOReceber.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOReceber obterReceber(@PathParam("id") int id) throws Exception {
        return BOReceber.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BOReceber.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
