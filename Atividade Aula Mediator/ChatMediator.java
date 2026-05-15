import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<User> users;

    public ChatMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(User user, String message) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(" de " + user.name + ": " + message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.users.remove(user);
    }
}
