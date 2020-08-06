package com.fouo.product.web;

import com.fouo.product.entity.Category;
import com.fouo.product.service.ICategoryService;
import com.fouo.product.vo.Catalog2VO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 商城页面 首页控制器
 * <p>
 * 模板引擎thymeleaf-starter：关闭缓存
 * <p>
 * 静态资源都放在static文件夹下，就可以按照路径直接访问
 * <p>
 * 页面放在templates下，springboot访问项目的时候 默认会找index
 * <p>
 * 页面修改不重启服务器实时更新
 * 引入dev-tools
 *
 * @author fouo
 * @date 2020/7/28 11:16
 */
@Controller
@AllArgsConstructor
@Api(value = "首页值", tags = "首页接口")
public class IndexController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 页面跳转
     *
     * @return
     */
    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        //TODO 1.查出所有的1级分类
        List<Category> list = categoryService.getTopCategory();
        model.addAttribute("categorys", list);
        return "index";
    }

//index/catalog.json
    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catalog2VO>> getCatalogJson() {
        Map<String, List<Catalog2VO>> map =  categoryService.getCatalogJson();
        return map;
    }
}
