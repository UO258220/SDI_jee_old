package com.uniovi.sdi;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServlerProductos
 */
@WebServlet("/productos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosService ps = new ProductosService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		LinkedList<Producto> productosTienda = (LinkedList<Producto>) ps.getProductos();
		// Retornar la vista con parámetro "producto"
		request.setAttribute("productosTienda", productosTienda);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
