package data;

import java.io.Serializable;

public interface System extends Serializable {
    void loadData();
    void login();
    void displayInfo();
    void grantAccess();
    void saveData();
}
