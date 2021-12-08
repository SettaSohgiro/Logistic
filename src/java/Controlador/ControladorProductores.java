/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloProductores;
import include.Productor;

/**
 *
 * @author me
 */
public class ControladorProductores {
    
    public boolean crearProducto(Productor p){
        ModeloProductores mpr =new ModeloProductores();
        return mpr.crear_productor(p);
    }
    
    public String getviewProductos(){
        String htmlcode = "";
        
        ModeloProductores modelou = new ModeloProductores();
        
        for(Productor p : modelou.getAllProductores()){
            
            htmlcode += "<tr>\n" +
                        "<td>"+p.getNombre_productor()+"</td>\n" +
                        "<td>"+p.getDireccion()+"</td>\n" +
                        "<td>"+p.getTelefono()+"</td>\n" +
                        "<td><button name=\" "+p.getId_productor()+"\" type=\"button\" class=\"btn btn-info\">Actualizar</button></td>\n" +
                        "<td><button name=\" "+p.getId_productor()+"\" type=\"button\" class=\"btn btn-danger\">Borrar</button></td>\n" +
                        "</tr>";
      
        }
        
        return htmlcode;
    }
    
//        public String getDetallesProducto(int idProducto){
//        String htmlcode = "";
//        Producto pr = new ModeloProductos().getProductor(idProducto);
//        htmlcode = "<div class=\"single\" >\n" +
//"         \n" +
//"		<div class=\"cont span_2_of_3\">\n" +
//"			  <div class=\"labout span_1_of_a1\">\n" +
//"				<!-- start product_slider -->\n" +
//"				     <ul id=\"etalage\">\n" +
//"							<li>\n" +
//"								<a href=\"optionallink.html\">\n" +
//"									<img class=\"etalage_thumb_image\" src='"+pr.getImagen_1()+"' />\n" +
//"									<img class=\"etalage_source_image\" src='"+pr.getImagen_1()+"' />\n" +
//"								</a>\n" +
//"							</li>\n" +
//"							<li>\n" +
//"									<img class=\"etalage_thumb_image\" src='"+pr.getImagen_2()+"' />\n" +
//"									<img class=\"etalage_source_image\" src='"+pr.getImagen_2()+"' />\n" +
//"							</li>\n" +
//"							<li>\n" +
//"									<img class=\"etalage_thumb_image\" src='"+pr.getImagen_3()+"' />\n" +
//"									<img class=\"etalage_source_image\" src='"+pr.getImagen_3()+"' />\n" +
//"							</li>\n" +
//"						</ul>\n" +
//"					\n" +
//"					\n" +
//"			<!-- end product_slider -->\n" +
//"			</div>\n" +
//"			<div class=\"cont1 span_2_of_a1\">\n" +
//"				<h3 class=\"m_3\">"+pr.getNombre()+"</h3>\n" +
//"				\n" +
//"				<div class=\"price_single\">\n" +
//"							  <span class=\"actual\">$"+pr.getPrecio()+"</span><a href=\"#\">click for offer</a>\n" +
//"							</div>\n" +
//"				<ul class=\"options\">\n" +
//"					<h4 class=\"m_9\">Select a Size</h4>\n" +
//"					<li><a href=\"#\">"+pr.getId()+"</a></li>\n" +
//"					<div class=\"clear\"></div>\n" +
//"				</ul>\n" +
//"				<div class=\"btn_form\">\n" +
//"				   <form>\n" +
//"					 <input type=\"submit\" value=\"buy now\" title=\"\">\n" +
//"				  </form>\n" +
//"				</div>\n" +
//"				<ul class=\"add-to-links\">\n" +
//"    			   <li><img src=\"images/wish.png\" alt=\"\"/><a href=\"#\">Add to wishlist</a></li>\n" +
//"    			</ul>\n" +
//"    			<p class=\"m_desc\">"+pr.getDescripcion()+"</p>\n" +
//"    			\n" +
//"                <div class=\"social_single\">	\n" +
//"				   <ul>	\n" +
//"					  <li class=\"fb\"><a href=\"#\"><span> </span></a></li>\n" +
//"					  <li class=\"tw\"><a href=\"#\"><span> </span></a></li>\n" +
//"					  <li class=\"g_plus\"><a href=\"#\"><span> </span></a></li>\n" +
//"					  <li class=\"rss\"><a href=\"#\"><span> </span></a></li>		\n" +
//"				   </ul>\n" +
//"			    </div>\n" +
//"			</div>\n" +
//"			<div class=\"clear\"></div>\n" +
//"     \n" +
//"     \n" +
//"	    \n" +
//"	 <div class=\"toogle\">\n" +
//"     	<h3 class=\"m_3\">Product Details</h3>\n" +
//"     	<p class=\"m_text\">"+pr.getDetalle()+"</p>\n" +
//"     </div>					\n" +
//"	 <div class=\"toogle\">\n" +
//"     	<h3 class=\"m_3\">Product Reviews</h3>\n" +
//"     	<p class=\"m_text\">>"+pr.getDetalle()+"</p>\n" +
//"     </div>\n" +
//"     </div>\n" +
//"     <div class=\"clear\"></div>\n" +
//"	 \n" +
//"	 \n" +
//"       </div>";
//        
//        
//        
//        return htmlcode;
//    }
    
    
//    public String getPanelView(){
//        String htmlcode = "";
//        ModeloProductos mp = new ModeloProductos();
//        ArrayList<Producto> productos = mp.getAllProductores();
//        
//        htmlcode += "<table border=\"1\">\n" +
//"            <tr>\n" +
//"                <th>ID</th>\n" +
//"                <th>Nombre</th>\n" +
//"                <th>Descripción</th>\n" +
//"                <th>Precio</th>\n" +
//"                <th>Categoria</th>\n" +
//"                <th>Detalles</th>\n" +
//"                <th>Acciones</th>\n" +
//"                <!--<th>Imagen_2</th>-->\n" +
//"                <!--<th>Imagen_3</th>-->\n" +
//"            </tr>\n";
//        
//        for (Producto p : productos) {
//            htmlcode += "<tr>\n" +
//"                <td id='id_producto'>"+p.getId()+"</td>\n" +
//    "                <td>"+p.getNombre()+"</td>\n" +
//    "                <td>"+p.getDescripcion()+"</td>\n" +
//    "                <td>"+p.getPrecio()+"</td>\n" +
//    "                <td>"+p.getCategoria()+"</td>\n" +
//    "                <td>"+p.getDetalle()+"</td>\n" +
//    "                <td>Acciones</td>\n" +
//    "                <td><a id='btn-eliminar' href=\"\">Eliminar</a> <a id='btn-modificar' href='modificar.jsp?id="+p.getId()+"'>Modificar</a></td>\n" +
//"                </tr>\n";
//        }
//        
//        htmlcode += "</table>";
//        
//        return htmlcode;
//    }
//    
//    public String getEditViewProducto(int idProducto){
//        ModeloProductos mp = new ModeloProductos();
//        Producto pr = mp.getProductor(idProducto);
//        String htmlcode = "";
//        htmlcode += "<form name=\"frmmodificar\" id=\"frmmodificar\">\n" +
//"            <table>\n" +
//"                <tr>\n" +
//"                    <td><input type=\"hidden\" name=\"idproducto\" id=\"idproducto\" value='"+pr.getId()+"' ></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><label for=\"\">Nombre:</label></td>\n" +
//"                    <td><input type=\"text\" name=\"nombre\" id=\"nombre\" value='"+pr.getNombre()+"'></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><label for=\"\">Descripción:</label></td>\n" +
//"                    <td><textarea cols=\"30\" rows=\"6\" name=\"descripcion\" id=\"descripcion\"> "+pr.getDescripcion()+"</textarea></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><label for=\"\">Precio:</label></td>\n" +
//"                    <td><input type=\"text\" name=\"precio\" id=\"precio\" value='"+pr.getPrecio()+"'></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><label for=\"\">Categoria:</label></td>\n" +
//"                    <td><input type=\"text\" name=\"categoria\" id=\"categoria\" value='"+pr.getCategoria()+"'></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><label for=\"\">Detalles:</label></td>\n" +
//"                    <td><input type=\"text\" name=\"detalles\" id=\"detalles\" value="+pr.getDetalle()+"></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td></td>\n" +
//"                    <td><input type=\"submit\" value=\"Modificar Producto\" id=\"btnmodificarproducto\"></td>\n" +
//"                </tr>\n" +
//"            </table>\n" +
//"        </form>";
//        return htmlcode;
//    }
    
    public boolean updateProducto(Productor p){
        ModeloProductores mpr = new ModeloProductores();
        return mpr.update_productor(p);
    }
    
    public boolean deleteProducto(int id){
        ModeloProductores mp = new ModeloProductores();
        return mp.deleteProductor(id);
    }
}
