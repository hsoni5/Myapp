package com.soni.app.batch.test;

 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
 
@ContextConfiguration(locations={"classpath:context.config.xml",
"classpath:job-config.xml"})
public class ExamJob {
    @SuppressWarnings("resource")
    public static void main(String areg[]){
 
        ApplicationContext context = new ClassPathXmlApplicationContext("job-config.xml");
 
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("examResultJob");
 
        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Exit Status : "+ execution.getStatus());
 
        } catch (JobExecutionException e) {
            System.out.println("Job ExamResult failed");
            e.printStackTrace();
        }
    }
 
}
