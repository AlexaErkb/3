package org.example;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {
    public int compare(Client s1, Client s2) {
        if (s1.townType==3 & s2.townType==3) {
            return 1;
        } else if (s1.townType!=3 & s2.townType==3) {
            return 1;
        } else if (s1.townType==3 & s2.townType!=3) {
            return -1;
        } else if (s1.townType!=3 & s2.townType!=3) {
            return 1;
        }
        return 0;
    }
}
