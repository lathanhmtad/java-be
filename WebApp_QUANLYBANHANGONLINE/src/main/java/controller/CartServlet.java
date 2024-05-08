package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.Item;
import Model.SANPHAM;
import dao.DAO;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final DAO productDAO=new DAO();
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String command=request.getParameter("command");
		String productID=request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");
		try {
			Long idProduct  = Long.parseLong(productID);
			SANPHAM product= productDAO.getProductByID(productID);
			switch (command) {
			case "flus": 
			{
				if (cart.getListItem().containsKey(idProduct)) {
					cart.AddItem(idProduct, new Item(product, cart.getListItem().get(idProduct).getQuantity()));
				}
				else
				{
					cart.AddItem(idProduct, new Item(product,1));
				}
				break;
			}
			case "remove":
				cart.DeleteItem(idProduct);
				break;
			}
		}
		catch (Exception  ex)
		{
			ex.printStackTrace();
			response.sendRedirect("/index.jsp");
		}
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
