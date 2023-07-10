package ex072;
import java.util.*;

public interface ProductDAO {
	//오류날 가능성이 있기 때문에 트라이케치 하라고 익셉션 던진거임. (나중에 할때)
	public void insert(ProductVO vo)throws Exception;
	public void update(ProductVO vo)throws Exception;
	public void delete(int pcode)throws Exception;
	public ProductVO read(int pcode)throws Exception;
	public List<ProductVO> list()throws Exception;
}
