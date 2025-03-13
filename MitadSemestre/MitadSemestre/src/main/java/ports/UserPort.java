package ports;

import app.domain.models.User;

public interface UserPort {
	
	public boolean existUserName(String userName);
	public void saveUser(User user);
	public User findByUserName(User user);
}
