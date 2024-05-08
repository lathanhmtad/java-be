package dao;

import java.util.List;

public interface DAOInterface<T> {

	// default value insert method
	public boolean insert();

	// inserts an object and returns the details of the inserted object
	public T insert(T o);

	public boolean update(T o);

	public boolean delete(T o);

	public T getO(T o);

	public List<T> getAll();
}
