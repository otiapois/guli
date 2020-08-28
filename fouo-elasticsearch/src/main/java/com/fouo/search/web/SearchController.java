package com.fouo.search.web;

import com.fouo.search.service.IMallSearchService;
import com.fouo.search.vo.SearchParam;
import com.fouo.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * search页面跳转
 * 只是用来进行页面跳转
 *
 * @author fouo
 * @date 2020/8/7 14:53
 */
@Controller
public class SearchController {
    @Autowired
    private IMallSearchService mallSearchService;

    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam, Model model) {
        //根据页面传递来的参数，去ES中检索商品
        SearchResult result = mallSearchService.search(searchParam);
        model.addAttribute("result", result);
        return "list";
    }
}
