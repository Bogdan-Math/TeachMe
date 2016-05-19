package ua.teachme.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.teachme.model.User;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserRestController extends AbstractUserController{

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public User getByEmail(String email) {
        return super.getByEmail(email);
    }

    @Override
    public void evictCache() {
        super.evictCache();
    }
}
