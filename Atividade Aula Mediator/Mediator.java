interface Mediator {
    void sendMessage(User user, String message);

    void addUser(User user);

    void removeUser(User user);
}