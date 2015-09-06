package test;

import java.util.List;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;
import biz.MovieBiz;
import biz.impl.MovieBizImpl;

public class Test {
	public static void main(String[] args) {
		//selectType();
		//addMovie();
		//showList();
		//getAll();
		MovieBiz movieBiz = new MovieBizImpl();
		Type type=movieBiz.getTypeById(16);
		MovieCondition condition = new MovieCondition(null, null, "%1%", 9.0, 9999.0, type);
		searchByCondition(condition);
	}

	private static void searchByCondition(MovieCondition condition) {
		MovieDao movieDao = new MovieDaoImpl();
		List<Movie> movies = movieDao.searchByCondition(condition);
		for (Movie movie : movies) {
			System.out.println(movies);
			System.out.println("dfsfdfd");
		}
	}

	private static void getAll() {
		MovieDao movieDao = new MovieDaoImpl();
		List<Movie> list = movieDao.getAll();
		for (Movie movie : list) {
			System.out.println(movie.getId()+"  "+movie.getType().getName());
		}
		
	}

	private static void showList() {
		 //实例化 DetachedCriteria  
        //DetachedCriteria dc = DetachedCriteria.forClass(Movie.class);  
        String actor = "主演111";
        String director="导演111";
        String titile="电影名称111";
        double priceBegin=12.00;
        double priceEnd = 999.00;
        int typeid=1;
        
        MovieDao movieDao = new MovieDaoImpl();
		List<Movie> movies =  movieDao.search(actor, director, titile, priceBegin, priceEnd, typeid);
		System.out.println("fffffffffffffffffffff");
		for (Movie movie : movies) {
			System.out.println(movie.getPrice());
		}
        System.out.println("fffffffffffffffffffff");
        /*
        int typeid = 1;
        if(actor!=null){
        	 dc.add(Restrictions.eq("actor",actor ));  
        }
        if(actor!=null){
       	 dc.add(Restrictions.eq("director",director ));  
       }
        if(actor!=null){
       	 dc.add(Restrictions.eq("titile",titile ));  
       }
        Criteria critera = dc.getExecutableCriteria(HibernateSessionFactory .getSession());  
        List<Movie> movies = critera.list();  
        System.out.println("fffffffffffffffffffff");
        
        for (Movie movie : movies) {
			System.out.println(movie.getPrice());
		}
        System.out.println("fffffffffffffffffffff");
        */
		
	}

	private static void addMovie() {
		Movie movie = new Movie("电影名称666","导演666" , "主演666", 111.00);
		MovieBiz movieBiz = new MovieBizImpl();
		movieBiz.addMovie(movie);
	}

	private static void selectType() {
		MovieBiz movieBiz = new MovieBizImpl();
		List<Type> types = movieBiz.getAllType();
		for (Type type : types) {
			System.out.println(type.getId()+" "+type.getName());
		}
	}
}
