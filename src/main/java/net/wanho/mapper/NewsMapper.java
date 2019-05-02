package net.wanho.mapper;

import net.wanho.mapper.base.BaseMapper;
import net.wanho.pojo.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper extends BaseMapper<News> {


    public List<News> selectnewsList();
}