/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import bo.BOUnidade;
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
import to.TOUnidade;


/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("unidade")
public class ServiceUnidade {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceUnidade() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOUnidade inserir(TOUnidade cliente) throws Exception {
        BOUnidade.inserir(cliente);
        return cliente;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOUnidade alterar(TOUnidade unidade) throws Exception {

        BOUnidade.alterar(unidade);

        return unidade;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOUnidade> obterUnidade() throws Exception {
        return BOUnidade.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOUnidade obterUnidade(@PathParam("id") int id) throws Exception {
        return BOUnidade.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BOUnidade.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
