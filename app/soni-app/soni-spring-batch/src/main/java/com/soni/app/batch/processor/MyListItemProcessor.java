package com.soni.app.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soni.app.batch.model.TradLifePolicy;
public class MyListItemProcessor implements ItemProcessor<TradLifePolicy,TradLifePolicy>{
	 
    public TradLifePolicy process(TradLifePolicy tradLifes) throws Exception {
        System.out.println("Processing trad Life result :"+tradLifes);
             
   return tradLifes;
       
    }

	

	
 
}
   

