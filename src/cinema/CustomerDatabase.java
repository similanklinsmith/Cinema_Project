package cinema;

public interface CustomerDatabase {
    int insert(Customer obj);
    int delete(Customer obj);
    int update(Customer obj);
}
