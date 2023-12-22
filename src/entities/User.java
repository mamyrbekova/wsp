package entities;

import java.io.*;
import java.util.*;
import containers.Journal;
import messages.Notification;


public abstract class User implements Serializable, Observer {
    private String userId;
    private Login login;
    private String email;
    private String name;
    private String surname;
    private Vector<Notification> notifications;
    private Vector<Journal> subscribedJournals;

    {
        subscribedJournals = new Vector<Journal>();
        notifications = new Vector<Notification>();
    }

    public User() {
    }

    public User(String userId, Login login, String email, String name, String surname) {
        this.userId = userId;
        this.login = login;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public void subscribeToJournal(Journal journal){
        subscribedJournals.add(journal);
    }
    public void viewNews(){
        // TODO vawe hz poka
    }
    public void logOut(){
        // TODO vawe hz poka
    }
    public void unsubscribeFromJournal(Journal journal){
        subscribedJournals.remove(journal);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Vector<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Vector<Notification> notifications) {
        this.notifications = notifications;
    }

    public Vector<Journal> getSubscribedJournals() {
        return subscribedJournals;
    }

    public void setSubscribedJournals(Vector<Journal> subscribedJournals) {
        this.subscribedJournals = subscribedJournals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(notifications, user.notifications) && Objects.equals(subscribedJournals, user.subscribedJournals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, email, name, surname, notifications, subscribedJournals);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", login=" + login +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", notifications=" + notifications +
                ", subscribedJournals=" + subscribedJournals +
                '}';
    }

    @Override
    public void notifyNewPaper(Notification notification) {
    	notifications.add(notification);
    }
}
