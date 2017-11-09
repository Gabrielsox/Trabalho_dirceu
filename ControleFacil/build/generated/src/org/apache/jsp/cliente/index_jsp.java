package org.apache.jsp.cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/cliente/../menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jsutil.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/index.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      out.write("<h1>Controle Facil</h1>\n");
      out.write("<a href=\"/\">Home</a>|\n");
      out.write("<a href=\"/cliente\">Cliente</a>|\n");
      out.write("<a href=\"/fornecedor\">Fornecedor</a>|\n");
      out.write("<a href=\"/produto\">Produto</a>|\n");
      out.write("<a href=\"/venda\">Venda</a>|\n");
      out.write("<a href=\"/despesa\">Despesa</a>|\n");
      out.write("\n");
      out.write("<hr/>");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1>Cadastro</h1>\n");
      out.write("\n");
      out.write("        <input id=\"id\" type=\"hidden\"/>\n");
      out.write("\n");
      out.write("        Nome<br/>\n");
      out.write("        <input id=\"nome\" type=\"text\"/><br/>\n");
      out.write("        E-mail<br/>\n");
      out.write("        <input id=\"email\" type=\"text\"/><br/>\n");
      out.write("        Endereco<br/>\n");
      out.write("        <input id=\"endereco\" type=\"text\"/><br/>\n");
      out.write("        Telefone<br/>\n");
      out.write("        <input id=\"telefone\" type=\"text\"/><br/>\n");
      out.write("        Observação<br/>\n");
      out.write("        <input id=\"observacao\" type=\"text\"/><br/><br/>\n");
      out.write("        \n");
      out.write("        <input id=\"btnSalvar\" type=\"button\" value=\"Salvar\"/>\n");
      out.write("\n");
      out.write("        <br/><br/>\n");
      out.write("\n");
      out.write("        <table id=\"tabela\" border=\"1\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
