package ua.teachme.util.logging;

import org.slf4j.Logger;
import org.slf4j.MDC;

import static org.slf4j.LoggerFactory.getLogger;

public class LogUtil {

    private static final Logger LOG = getLogger(LogUtil.class/*logged class*/);

    private void log(){
        /* all options in: ua.teachme.resources/logback.xml */
        MDC.put("logger_id", "filename_to_logging");
        LOG.debug("logging");
    }
}