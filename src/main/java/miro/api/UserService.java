package miro.api;

import io.dropwizard.lifecycle.Managed;
import java.util.HashMap;
import javax.inject.Singleton;
import miro.core.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class UserService implements Managed {
  private final Logger logger = LoggerFactory.getLogger(UserService.class);
  private HashMap<Long, User> users = new HashMap<>();

  public User getById(long id) {
    return users.get(id);
  }

  @Override
  public void start() throws Exception {
    logger.debug("Staring user service");
    users.put(1L, new User(1, "miro"));
  }
  @Override
  public void stop() throws Exception {
    logger.debug("tearing down user service");
  }
}
