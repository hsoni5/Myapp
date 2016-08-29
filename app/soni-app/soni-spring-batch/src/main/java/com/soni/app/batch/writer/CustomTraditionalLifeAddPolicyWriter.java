package com.soni.app.batch.writer;


import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.soni.app.batch.dao.MyListDao;
import com.soni.app.batch.model.TradLifePolicy;

public class CustomTraditionalLifeAddPolicyWriter implements ItemWriter<TradLifePolicy> {

  public void write(List<? extends TradLifePolicy> items) throws Exception {

	System.out.println("writer..." + items.size());
	 MyListDao  dao= new MyListDao();
	for(TradLifePolicy item : items){
		
	       
     	dao.insertData(item);
     	;
	}

  }

}
