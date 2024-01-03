<%-- 
    Document   : producto
    Created on : 16 sep. 2019, 15:23:22
    Author     : JC
--%>

<%@page import="com.modelo.Producto"%>
<%@page import="com.modelo.DaoProducto"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Proveedor"%>
<%@page import="com.modelo.DaoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script lang="JavaScript">
            function cargar(codigo, nombre, categoria, precio, anioFa, anioVen, proveedor){
                document.frmProducto.txtCodigo.value = codigo;
                document.frmProducto.txtNombre.value = nombre;
                document.frmProducto.txtCategoria.value = categoria;
                document.frmProducto.txtPrecio.value = precio;
                document.frmProducto.txtAnioFabricacion.value = anioFa;
                document.frmProducto.txtAnioVencimiento.value = anioVen;
                document.frmProducto.selectProveedor.value = proveedor;
                
            }
        </script>
        
            <% if (request.getSession().getAttribute("msj")!=null) {
                    
                
            %>
            <script type="text/javascript">
            alert('<%= request.getSession().getAttribute("msj") %>');
                </script>
                
            <% } %>
        
    </head>
    <% DaoProducto dp = new DaoProducto(); %>
    <body>
        <h1>CRUD Producto</h1>
    <center>
        <table border="2">
            <form action="procesarProducto" method="POST" name="frmProducto">
                <tr>
                    <td>Código Producto</td>
                    <td><input type="text" name="txtCodigo"></td>
                </tr>
                <tr>
                    <td>Nombre Producto</td>
                    <td><input type="text" name="txtNombre"></td>
                </tr>
                <tr>
                    <td>Categoría</td>
                    <td><input type="text" name="txtCategoria"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="txtPrecio"></td>
                </tr>
                <tr>
                    <td>Año de fabricación</td>
                    <td><input type="text" name="txtAnioFabricacion"></td>
                </tr>
                <tr>
                    <td>Año de vencimiento</td>
                    <td><input type="text" name="txtAnioVencimiento"></td>
                </tr>
                <tr>
                    <td>Proveedor</td>
                    <td><select name="selectProveedor">
                        <% List<Proveedor> lst = dp.listarProveedores();
                        for(Proveedor p: lst){
                            
                        
                        %>
                        <option value="<%= p.getCodigoProveedor() %>"><%= p.getNombre() %></option>
                        <% } %>
                        </select></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btnSave" value="Guardar">
                        <input type="submit" name="btnModificar" value="Modificar" onclick="return confirm('¿Modificar?')">
                        <input type="submit" name="btnEliminar" value="Eliminar" onclick="return confirm('¿Eliminar?')">
                        <input type="reset" name="btnLimpiar" value="Limpiar">
                    </td>
                    
                </tr>
                
            </form>
        </table>
                        <br>
                        <br>
                        <hr>
                        <table border="2">
                            <thead>
                                <tr>
                            <th>Código Producto</th>
                            <th>Nombre</th>
                            <th>Categoría</th>
                            <th>Precio</th>
                            <th>Año de Fabricación</th>
                            <th>Año de Vencimiento</th>
                            <th>Proveedor</th>
                            <th>Seleccionar</th>
                                </tr>
                            </thead>
                            
                            <tbody>
                                <% List<Producto> lstPro = dp.mostrarProducto();
                                for(Producto pro: lstPro){
                                %>
                                <tr>
                                    <td><%= pro.getCodigoProducto() %></td>
                                    <td><%= pro.getNombre() %></td>
                                    <td><%= pro.getCategoria() %></td>
                                    <td><%= pro.getPrecio() %></td>
                                    <td><%= pro.getAnioFabricacion() %></td>
                                    <td><%= pro.getAnioVencimiento() %></td>
                                    <td><%= pro.getProveedor().getCodigoProveedor() %></td>
                                    
                                    <td><a href="javascript:cargar(<%= pro.getCodigoProducto()%>,
                                           '<%= pro.getNombre() %>','<%= pro.getCategoria() %>',
                                           '<%= pro.getPrecio() %>','<%= pro.getAnioFabricacion() %>',
                                           '<%= pro.getAnioVencimiento() %>','<%= pro.getProveedor().getCodigoProveedor() %>')">Seleccionar</a></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
    </center>
                        
    </body>
</html>
