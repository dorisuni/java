package ex07;

public interface ProductDAO2 {
    public void insert(ProductVO vo)throws Exception;
    public void update(ProductVO vo)throws Exception;
    public void delete (int pcode) throws Exception;
    
}
