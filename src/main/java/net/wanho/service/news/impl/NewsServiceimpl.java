package net.wanho.service.news.impl;

import net.wanho.mapper.NewsMapper;
import net.wanho.pojo.News;
import net.wanho.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceimpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int deleteByPrimaryKey(Long tid) {
        return newsMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(News record) {
        return newsMapper.insert(record);
    }

    @Override
    public int insertSelective(News record) {
        return newsMapper.insertSelective(record);
    }

    @Override
    public News selectByPrimaryKey(Long tid) {
        return newsMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return 0;
    }

    @Override
    public List<News> selectnewsList() {
        return newsMapper.selectnewsList();
    }
}
