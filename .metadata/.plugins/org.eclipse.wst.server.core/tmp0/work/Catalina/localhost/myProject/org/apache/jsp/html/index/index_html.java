/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.68
 * Generated at: 2019-11-05 01:27:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.html.index;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_html extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"icon\" href=\"images/title.icon\" type=\"image/x-icon\">\r\n");
      out.write("        <title>首页导航</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("        <!-- CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index/supersized.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index/index.css\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("       <div class=\"main\">\r\n");
      out.write("    \t\t<div class=\"main-left\">\r\n");
      out.write("    \t\t\t<div class=\"list\">\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/1.jpg\" />\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/2.jpg\" />\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/3.jpg\" alt=\"\" />\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/1.jpg\" />\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/2.jpg\" />\r\n");
      out.write("    \t\t\t\t<img src=\"images/index/indexBackground/3.jpg\" alt=\"\" />\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("    \t\t<div class=\"main-right\">\r\n");
      out.write("    \t\t\t<img src=\"images/index/indexBackground/1.jpg\" />\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </body>\r\n");
      out.write(" \t<!-- Javascript -->\r\n");
      out.write("    <script src=\"javaScript/jquery/jquery-1.8.2.min.js\"></script>       \r\n");
      out.write("    <script src=\"javaScript/index/supersized.3.2.7.min.js\"></script>\r\n");
      out.write("    <script src=\"javaScript/index/supersized-init.js\"></script>\r\n");
      out.write("    <script src=\"javaScript/index/index.js\"></script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
