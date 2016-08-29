package com.soni.app.batch.test;

 
import java.util.Date;

import org.junit.runner.Request;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.soni.app.batch.model.TraditionalLifeAddPolicyRequest;
 
@ContextConfiguration(locations={"classpath:context.config.xml",
"classpath:job-config.xml"})
public class MyJob {
	 
	

	@SuppressWarnings("resource")
    public static void main(String areg[]){
		
        ApplicationContext context = new ClassPathXmlApplicationContext("job-config.xml");
        TraditionalLifeAddPolicyRequest request=(TraditionalLifeAddPolicyRequest)context.getBean("tradRequest");
        request.setPolicyNumber("abc");
        request.setRunDate(new Date());
        request.setProductType("wma");
        
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        
        Job job = (Job) context.getBean("listBatchJob");
       
        String dateParam = new Date().toString();
    	JobParameters param =  new JobParametersBuilder().addString("policyNumber", dateParam).toJobParameters();

    	System.out.println(dateParam);
      
        try {
            JobExecution execution = jobLauncher.run(job,param);
            System.out.println("Job Exit Status : "+ execution.getStatus());
 
        } catch (JobExecutionException e) {
            System.out.println("Job ExamResult failed");
            e.printStackTrace();
        }
    }
   
}
