package sg.ihh.ms.fms.app.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

    protected Logger log;

    public BaseService() {
        // Empty Constructor
    }

    protected Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    protected void start(String methodName) {
        log.debug("[{}] Start", methodName);
    }

    protected void completed(String methodName) {
        log.debug("[{}] Completed", methodName);
    }

}
