package cn.dao;
import java.util.List;
import cn.entity.Favorite;
/**
 * 收藏夹的DAO
 */
public interface FavDAO extends BaseDao<Favorite> {
	/**
	 * 根据指定的类型查询收藏列表
	 * @param type
	 * @return
	 */
	public List<Favorite> search(String type);
	
}