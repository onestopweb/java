package cn.entity;
import java.util.Date;
/**
 * 标准信息表
 * */
@SuppressWarnings("serial")
public class Standards implements java.io.Serializable {
	private Integer stdId;//标准 id
	private String stdNum;//标准号
	private String zhname;//中文名称
	private String stdVersion;//版本
	private String keys;//关键字/词
	private Date releaseDate;//发布日期
	private Date implDate;//实施日期
	private String packagePath;//附件路径
	public Standards() {
		super();
	}
	public Standards(String stdNum, String zhname, String stdVersion,
			String keys, Date releaseDate, Date implDate, String packagePath) {
		super();
		this.stdNum = stdNum;
		this.zhname = zhname;
		this.stdVersion = stdVersion;
		this.keys = keys;
		this.releaseDate = releaseDate;
		this.implDate = implDate;
		this.packagePath = packagePath;
	}
	public Standards(Integer stdId, String stdNum, String zhname,
			String stdVersion, String keys, Date releaseDate, Date implDate,
			String packagePath) {
		super();
		this.stdId = stdId;
		this.stdNum = stdNum;
		this.zhname = zhname;
		this.stdVersion = stdVersion;
		this.keys = keys;
		this.releaseDate = releaseDate;
		this.implDate = implDate;
		this.packagePath = packagePath;
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getZhname() {
		return zhname;
	}
	public void setZhname(String zhname) {
		this.zhname = zhname;
	}
	public String getStdVersion() {
		return stdVersion;
	}
	public void setStdVersion(String stdVersion) {
		this.stdVersion = stdVersion;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getImplDate() {
		return implDate;
	}
	public void setImplDate(Date implDate) {
		this.implDate = implDate;
	}
	public String getPackagePath() {
		return packagePath;
	}
	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}
	@Override
	public String toString() {
		return "Standards [stdId=" + stdId + ", stdNum=" + stdNum + ", zhname="
				+ zhname + ", stdVersion=" + stdVersion + ", keys=" + keys
				+ ", releaseDate=" + releaseDate + ", implDate=" + implDate
				+ ", packagePath=" + packagePath + "]";
	}
}