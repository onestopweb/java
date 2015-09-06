package cn.biz.impl;
import java.util.List;
import cn.biz.StandardsBiz;
import cn.dao.StandardsDao;
import cn.entity.Standards;
public class StandardsBizImpl implements StandardsBiz {
	private StandardsDao standardsDao;
	public void setStandardsDao(StandardsDao standardsDao) {
		this.standardsDao = standardsDao;
	}
	@Override
	public List<Standards> findAll() {
		return standardsDao.findAll();
	}
	@Override
	public List<Standards> findByPage(int pageIndex, int pageSize) {
		int begin = (pageIndex - 1) * pageSize;
		return standardsDao.findByPage(begin, pageSize);
	}
	@Override
	public List<Standards> findByPageOfsearch(int pageIndex, int pageSize,
			String stdNum) {
		int begin = (pageIndex - 1) * pageSize;
		return standardsDao.findByPageOfsearch(begin, pageSize,stdNum);
	}
	@Override
	public Standards findById(Integer stdId) {
		return standardsDao.findById(stdId);
	}
	@Override
	public void update(Standards standards) {
		standardsDao.update(standards);
	}
	@Override
	public void insert(Standards standards) {
		standardsDao.insert(standards);
	}
	@Override
	public void deleteByIds(Integer[] stdIds) {
		for (Integer integer : stdIds) {
			System.out.println(integer);
		}
		standardsDao.deleteByIds(stdIds);
	}
}
