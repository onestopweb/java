package action;
import java.util.ArrayList;
import java.util.List;
import entity.Goods;
import biz.GoodsBiz;
import biz.impl.GoodsBizImpl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 查询商品表的信息 Action
 * */
public class GetSelectedGoodsAction extends ActionSupport {
	private GoodsBiz goodsBiz=new GoodsBizImpl();
    private List<Goods>  goods=new ArrayList<Goods>();
    private Integer[] ids;
	public GoodsBiz getGoodsBiz() {
		return goodsBiz;
	}
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	@Override
	public String execute() throws Exception {
		
		try {
			goods=goodsBiz.getGoodsByIds(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}	
}
