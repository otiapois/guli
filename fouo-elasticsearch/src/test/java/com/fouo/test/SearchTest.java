package com.fouo.test;

import com.fouo.search.config.ElasticSearchConfig;
import com.google.gson.Gson;
import lombok.Data;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticSearchConfig.class)
public class SearchTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void run() {
        System.out.println(client);
    }

    /**
     * 向ES中存储数据
     */
    @Test
    public void indexEs() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
//        indexRequest.source("name", "zhangsan", "age", 24, "gender", "male");

        //构造json对象
        Person person = new Person("张三", 24, "male");
        Gson gson = new Gson();
        String json = gson.toJson(person);

        //要保存的内容
        indexRequest.source(json, XContentType.JSON);

        //使用客户端执行操作
        IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);

        //提取有用的响应数据
        System.out.println(index);
    }

    /**
     * 数据检索
     */
    @Test
    public void searchEs() throws IOException {
        //创建检索请求
        SearchRequest searchRequest = new SearchRequest();

        //指定索引
        searchRequest.indices("bank");

        //指定DSL，指定检索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchQuery("address", "mill"));

        //聚合条件
//        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("xxx").field("sss").size(10);
//        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);
        //执行检索
        SearchResponse search = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        //分析结果
        SearchHits hits = search.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
//            hit.getIndex();
//            hit.getType();
//            hit.getId();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println("1:"+sourceAsMap);
            String sourceAsString = hit.getSourceAsString();
            System.out.println("2:"+sourceAsString);
            BytesReference sourceRef = hit.getSourceRef();
            System.out.println("3:"+sourceRef);
        }
    }

    @Data
    class Person {
        private String name;
        private Integer age;
        private String gender;

        public Person() {
        }

        public Person(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }
}
