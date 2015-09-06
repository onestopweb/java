package cn.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import cn.biz.FavBiz;
import cn.biz.TagBiz;
import cn.entity.Favorite;
import cn.entity.Tag;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class FavAction extends ActionSupport {
	private FavBiz favBiz;//收藏
	private TagBiz tagBiz;//标记
	private Favorite fav;
	private Tag tag;
	private List<Favorite> favList;
	private List<Tag> tagList;
	private List<String> urlList;
	private String type;
	/*
	 * 到 add.jsp 页面去
	 */
	public String toAdd() throws Exception{
		return SUCCESS;
	}
	/*
	 * 添加收藏
	 * */
	public String doAdd() throws Exception{
		System.out.println(fav);
		favBiz.add(fav);
		System.out.println("2"+fav);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		String s = "<script>alert('添加成功');window.close();</script>";
		ServletActionContext.getResponse().getWriter().write(s);
		System.out.println("3"+fav);
		return null;
	}
	/*
	 * 到显示列表页面
	 * */
	public String toList() throws Exception{
		tagList = this.tagBiz.search(null);
		//为空，则表示查询所有的
		if(null==type || "".equals(type)){
			type="-1";
		}
		//因为通过 url 传递汉字，所以要解码
		type = new String(type.getBytes("iso-8859-1"),"utf-8");
		System.out.println(type);
		favList = this.favBiz.search(type);
		return SUCCESS;
	}
	/*
	 * 到显示云页面
	 * */
	public String toCloud() throws Exception{
		tagList = this.tagBiz.search(null);
		return SUCCESS;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FavBiz getFavBiz() {
		return favBiz;
	}
	public void setFavBiz(FavBiz favBiz) {
		this.favBiz = favBiz;
	}
	public TagBiz getTagBiz() {
		return tagBiz;
	}
	public void setTagBiz(TagBiz tagBiz) {
		this.tagBiz = tagBiz;
	}
	public Favorite getFav() {
		return fav;
	}
	public void setFav(Favorite fav) {
		this.fav = fav;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public List<Favorite> getFavList() {
		return favList;
	}
	public void setFavList(List<Favorite> favList) {
		this.favList = favList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public List<String> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
}
