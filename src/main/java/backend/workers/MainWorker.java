package backend.workers;


import backend.db.Broker;
import backend.db.ConnectionManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
@Startup
public class MainWorker {


    @Resource
    ManagedScheduledExecutorService scheduler;


    @EJB
    Handler handler;

    @PostConstruct
    public void init() {
        System.out.println( " **init** ");
        this.scheduler.schedule(this::start, 2, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void cleanUp() {

    }

    public void start() {

        try {
                List<Long> allStatus2 = Broker.getAllNotPermittedAndReady(1000, ConnectionManager.getFullStopConnection());

                Future<?> f = handler.handle(allStatus2);
                f.get();

            this.scheduler.schedule(this::start, 20 , TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
