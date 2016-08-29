package com.soni.app.batch.reader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soni.app.batch.model.TradLifePolicy;
import com.soni.app.batch.model.TraditionalLifeAddPolicyRequest;
import com.soni.app.batch.test.MyJob;
	 
  
	public class TraditionalLifePolicyReader implements ItemReader<TradLifePolicy> {
	   
	    private int nextLife;
	    private List<TradLifePolicy> tradLifes;
	   
	    TraditionalLifePolicyReader(TraditionalLifeAddPolicyRequest request) {
	    	request.setPolicyNumber("abc");
	        request.setRunDate(new Date());
	        request.setProductType("wma");
	        initialize(request);
	    }
	 
	    private void initialize(TraditionalLifeAddPolicyRequest request) {
	    	int i=0;
	    	tradLifes=new ArrayList<TradLifePolicy>();
			while(i<200){
				TradLifePolicy life=new TradLifePolicy();
				life.setFirstName("hari"+i);
				life.setLastName("soni"+i);
				life.setPolicyNumber("333");
			    life.setPolicyName(request.getPolicyNumber()+i);
			    life.setRunDate(request.getRunDate());
			    life.setProductName("TradPolicy");
			    life.setProductType("intermediate");
			    life.setPolicySatus("active");
			    life.setEmail("hari@soni.com");
			    life.setAddress("noida");
			    life.setPhone("266232723723");
			    life.setNation("india");
			    life.setState("u.p.");
			    life.setPincode("201301");
			    life.setBank("HDFC");
			    life.setPaymentMode("net banking");
			    life.setAmount("1000");
			    life.setType("mutual life");
			    life.setIssue("late payment");
			    life.setPary("wmaj");
			    life.setPartyName("csc");
			    life.setPartyType("csc");
			    life.setPartyAddress("us");
			    life.setPartyStatus("active");
			    life.setPartyNumber("41");
			    life.setDesig("SSE");
			    life.setIncome("9lac");
			    life.setSource("emp");
				tradLifes.add(life);
				i++;
			}
			System.out.println(tradLifes.size());
	    }
	 
	    
	    public TradLifePolicy read() throws Exception {
	    	TradLifePolicy life = null;
            	       
	        if (nextLife < tradLifes.size()) {
	            life = tradLifes.get(nextLife);
	            nextLife++;
	        }
	      
	        return life;
	    }
	}


