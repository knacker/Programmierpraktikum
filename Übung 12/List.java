//@author maximilian raspe
public interface List<T> {

    public void add(T obj);
    public void insert(T obj , int index);
    public T get(int index);
    public void delete(int index);
    public int indexOf(T obj);
    public int length ();
}
