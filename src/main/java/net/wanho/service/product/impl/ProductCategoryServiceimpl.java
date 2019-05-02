package net.wanho.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.ProductcategoryMapper;
import net.wanho.pojo.Productcategory;
import net.wanho.pojo.vo.ProductCategoryVO;
import net.wanho.service.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceimpl implements ProductCategoryService {

    @Autowired
    private ProductcategoryMapper productcategoryMapper;


    @Override
    public int deleteByPrimaryKey(Long tid) {
        return productcategoryMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Productcategory record) {
        return productcategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Productcategory record) {
        return productcategoryMapper.insertSelective(record);
    }

    @Override
    public Productcategory selectByPrimaryKey(Long tid) {
        return productcategoryMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Productcategory record) {
        return productcategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Productcategory record) {
        return productcategoryMapper.updateByPrimaryKey(record);
    }


    public List<ProductCategoryVO> getProductCategoryVOList(List<Productcategory> list){
        List<ProductCategoryVO> oneList=new ArrayList<ProductCategoryVO>();
        for (int i=0;i<list.size();i++)
        {
            ProductCategoryVO v1=new ProductCategoryVO();
            Productcategory parent1=list.get(i);
            v1.setPc(parent1);
            List<Productcategory> list2=productcategoryMapper.queryProductCategoryListbyParentId(parent1.getTid());
            if(list2!=null)
            {
                v1.setPcVOList(getProductCategoryVOList(list2));
                oneList.add(v1);
            }else {
                break;
            }
        }
        return oneList;
    }

    public List<ProductCategoryVO> getDomList(){

        List<ProductCategoryVO> oneList=new ArrayList<ProductCategoryVO>();
            List<Productcategory> list1 = productcategoryMapper.queryProductCategoryListbyParentId(0l);

            for(int i=0;i<list1.size();i++)
            {
                ProductCategoryVO v1=new ProductCategoryVO();

                Productcategory parent1=list1.get(i);
                v1.setPc(parent1);
                List<Productcategory> list2=productcategoryMapper.queryProductCategoryListbyParentId(parent1.getTid());

                List<ProductCategoryVO> twoList=new ArrayList<ProductCategoryVO>();
                for(int j=0;j<list2.size();j++)
                {
                    ProductCategoryVO v2=new ProductCategoryVO();

                    Productcategory parent2=list2.get(j);

                    v2.setPc(parent2);

                    List<Productcategory> list3=productcategoryMapper.queryProductCategoryListbyParentId(parent2.getTid());

                    List<ProductCategoryVO> threeList= new ArrayList<ProductCategoryVO>();

                    for(int k=0;k<list3.size();k++)
                    {
                        ProductCategoryVO v3=new ProductCategoryVO();

                        Productcategory pc=list3.get(k);

                        v3.setPc(pc);

                        threeList.add(v3);
                    }

                    v2.setPcVOList(threeList);

                    twoList.add(v2);
                }
                v1.setPcVOList(twoList);

                oneList.add(v1);
            }

        return oneList;

    }

    @Override
    public PageInfo<Productcategory> queryProductCategoryList(Integer start, Integer limit, Integer navigatePages) {
        PageHelper.startPage(start, limit);
        List<Productcategory> productcategories = productcategoryMapper.queryProductCategoryList();
        PageInfo<Productcategory> pageinfo=new PageInfo<Productcategory>(productcategories,navigatePages);
        return pageinfo;
    }

    @Override
    public List<Productcategory> queryProductCategoryListbyParentId(Long parentid) {
        return productcategoryMapper.queryProductCategoryListbyParentId(parentid);
    }


}
