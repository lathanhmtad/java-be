package model.ndd.dao.impl;

import java.util.List;

import com.ndd.dao.IProductDAO;
import com.ndd.mapper.ProductMapper;
import com.ndd.model.Product;

public class ProductDAOImpl extends AbstractDAOImpl<Product> implements IProductDAO {

	@Override
	public List<Product> findAll() {
		String sql = "SELECT p.*, c.name AS category_name\r\n"
					+ "FROM product p\r\n"
					+ "INNER JOIN category c ON p.category_id = c.id ";
		return query(sql, new ProductMapper());
	}

}
