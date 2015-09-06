package cn.biz;
import java.util.List;
import cn.entity.Favorite;
public interface FavBiz {
	public void add(Favorite fav);
	public List<Favorite> search(String type);
}
