package car.servis.servis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static final Logger LOG= LoggerFactory.getLogger(SessionListener.class);

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        LOG.info("New session is created. Adding Session to the counter.");
        counter.incrementAndGet();  //incrementing the counter
        updateSessionCounter(se);
        //max time session without action , then destroy session
        se.getSession().setMaxInactiveInterval(10);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOG.info("Session destroyed. Removing the Session from the counter.");
        counter.decrementAndGet();  //decrementing counter
        updateSessionCounter(se);
    }

    private void updateSessionCounter(HttpSessionEvent httpSessionEvent){
        //Let's set in the context
        httpSessionEvent.getSession().getServletContext()
                .setAttribute("activeSession", counter.get());
        LOG.info("Total active session are {} ",counter.get());
    }
}
