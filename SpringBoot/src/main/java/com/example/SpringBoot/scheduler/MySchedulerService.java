package com.example.SpringBoot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MySchedulerService {
    /*@Autowired
    private OutputInvoiceCloseService outputInvoiceCloseService;*/
 
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Scheduled(cron="0 0/1 * * * ?")
    public void exec(){
        logger.info("定时任务被执行....");
        //outputInvoiceCloseService.run();
        //InRequestLog queryById = inLogService.queryById(317249L);
		//System.out.println(queryById);
    }
}
