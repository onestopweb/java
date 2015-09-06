package bean;
/**
 * 以Movie 实体类为条件
 * */
public class MovieCondition {
	
	private String titile;//电影名称
	private String director;//导演
	private String actor;;//主演
	private Double minPrice;//最小价格
	private Double maxPrice;//最大价格
	private Type   type;//电影类型
	
	/*
	 * 构造方法
	 * */
	public MovieCondition() {
	}
	public MovieCondition(String titile, String director, String actor,
			Double minPrice, Double maxPrice, Type type) {
		this.titile = titile;
		this.director = director;
		this.actor = actor;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.type = type;
	}
	/*
	 * 封装方法
	 * */
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}
