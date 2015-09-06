package cn.entity;
@SuppressWarnings("serial")
public class Favorite implements java.io.Serializable {
	private Integer id;
	private String label;
	private String url;
	private String tags;
	private String desc;
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", label=" + label + ", url=" + url
				+ ", tags=" + tags + ", desc=" + desc + "]";
	}
	public Favorite() {
		super();
	}
	public Favorite(String label, String url, String tags, String desc) {
		super();
		this.label = label;
		this.url = url;
		this.tags = tags;
		this.desc = desc;
	}
	public Favorite(Integer id, String label, String url, String tags,
			String desc) {
		super();
		this.id = id;
		this.label = label;
		this.url = url;
		this.tags = tags;
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}