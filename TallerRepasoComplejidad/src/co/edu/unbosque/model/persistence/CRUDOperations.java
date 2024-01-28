package co.edu.unbosque.model.persistence;

public interface CRUDOperations<T> {
	
	public void create(T info);
	public boolean delete(int index);
	public boolean update(int index, T info);

}
