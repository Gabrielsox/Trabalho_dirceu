/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import bo.BODespesa;
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
import to.TODespesa;
import to.TORetorno;


/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("depesa")
public class ServiceDespesa {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceDespesa() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TODespesa inserir(TODespesa cliente) throws Exception {
        BODespesa.inserir(cliente);
        return cliente;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TODespesa alterar(TODespesa cliente) throws Exception {
        BODespesa.alterar(cliente);
        return cliente;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TODespesa> obterCliente() throws Exception {
        return BODespesa.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TODespesa obterCliente(@PathParam("id") int id) throws Exception {
        return BODespesa.obter(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {

        TORetorno r = new TORetorno();

        try {
            BODespesa.excluir(id);

            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }

        return r;
    }

}
