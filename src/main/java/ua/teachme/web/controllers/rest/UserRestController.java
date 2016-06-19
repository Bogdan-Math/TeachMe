package ua.teachme.web.controllers.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.teachme.model.User;
import ua.teachme.web.controllers.AbstractUserController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserRestController extends AbstractUserController {

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    //todo: add 'save' to REST functionality
    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    //todo: add 'delete' to REST functionality
    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    @RequestMapping(value = "/by", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByEmail(@RequestParam("userEmail") String email) {
        return super.getByEmail(email);
    }

    @RequestMapping(value = "/textUA", method = RequestMethod.GET)
    public String text() {
        return "Українська мова !!!";
    }
}
