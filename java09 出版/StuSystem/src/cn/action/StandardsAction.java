package cn.action;
import java.util.List;
import cn.biz.StandardsBiz;
import cn.entity.Standards;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class StandardsAction extends ActionSupport {
	private StandardsBiz standardsBiz;
	private List<Standards> standards;
	private Standards standard;
	private int pageIndex;
	private int pagecount;
	private Integer stdId;
	private String stdNum;
	private Integer[] stdIds; 
	public String toList() throws Exception{
		Integer pageSize = 4;
		pagecount = (int)Math.ceil((double)standardsBiz.findAll().size()/pageSize);
		if(pageIndex <= pagecount){
			if(stdNum == null){
				standards = standardsBiz.findByPage(pageIndex, pageSize);
			}else{
				standards = standardsBiz.findByPageOfsearch(pageIndex, pageSize, stdNum);
			}
		}else{
			if(stdNum == null){
				standards = standardsBiz.findByPage(pagecount, pageSize);
				pageIndex = pagecount;
			}else{
				standards = standardsBiz.findByPageOfsearch(pagecount, pageSize, stdNum);
				pageIndex = pagecount;
			}
		}
		return SUCCESS;
	}
	public String toUpdate() throws Exception{
		if(standard != null){
			standardsBiz.update(standard);
			return "tolist";
		}
		standard = standardsBiz.findById(stdId);
		return SUCCESS;
	}
	public String toAdd() throws Exception{
		if(standard != null){
			standardsBiz.insert(standard);
			return "tolist";
		}
		return SUCCESS;
	}
	public String toDelete() throws Exception{
		System.out.println(stdIds);
		standardsBiz.deleteByIds(stdIds);
		return SUCCESS;
	}
	public StandardsBiz getStandardsBiz() {
		return standardsBiz;
	}
	public void setStandardsBiz(StandardsBiz standardsBiz) {
		this.standardsBiz = standardsBiz;
	}
	public List<Standards> getStandards() {
		return standards;
	}
	public void setStandards(List<Standards> standards) {
		this.standards = standards;
	}
	public Standards getStandard() {
		return standard;
	}
	public void setStandard(Standards standard) {
		this.standard = standard;
	}
	public Integer getPageIndex() {
		if(pageIndex<=0){
			return 1;
		}
		return pageIndex;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public Integer[] getStdIds() {
		return stdIds;
	}
	public void setStdIds(Integer[] stdIds) {
		this.stdIds = stdIds;
	}
}
