package com.soni.app.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soni.app.batch.model.ExamResult;
 
 
public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{
 
    public ExamResult process(ExamResult result) throws Exception {
        System.out.println("Processing result :"+result);
 
        /*
         * Only return results which are equal or more than 75%
         *
         */
        if(result.getPercentage() < 75){
            return null;
        }
 
        return result;
    }
 
}
