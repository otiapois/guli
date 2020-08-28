package com.fouo.search.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fouo.search.vo.SearchParam;
import com.fouo.search.vo.SearchResult;

/**
 * 商城检索服务接口
 *
 * @author fouo
 * @date 2020/8/7 16:15
 */
public interface IMallSearchService extends IService<SearchParam> {

    /**
     * 检索功能
     * @param searchParam 检索的所有参数
     * @return  返回检索的结果
     */
    SearchResult search(SearchParam searchParam);
}
