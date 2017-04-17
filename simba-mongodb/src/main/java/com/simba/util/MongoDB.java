package com.simba.util;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

//@Component
public class MongoDB {

	@Autowired
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * 构造查询对象
	 * 
	 * @param params
	 * @return
	 */
	public Query buildQuery(Map<String, Object> params) {
//		Criteria c = null;
//		params.forEach((key,value)->{
//			c = 
//		});
//		Criteria.where("id").is(o);
		return null;
	}

	@PostConstruct
	private void init() {
		M m = new M();
		m.setAge(12);
		m.setName("我的");
		mongoTemplate.save(m);
		m.setAge(520);
		m.setName("yours");
		mongoTemplate.insert(m);
		List<M> l = mongoTemplate.findAll(M.class);
		System.out.println("***************" + l.toString() + "***********");
	}
}
