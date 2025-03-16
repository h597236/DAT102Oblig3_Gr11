package no.dat102.hvl.veke10.oppg4;

public class LenketMengde {

    Node head;


    public static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean inneholder(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void leggTil(Object data) {
        if (!inneholder(data)) {
            Node nyNode = new Node(data);
            nyNode.next = head;
            head = nyNode;
        }
    }

    public boolean erTom(){
        return head == null;
    }

    public void fjern(Object data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node root = head;
        while (root.next != null) {
            if (root.next.data.equals(data)) {
                root.next = root.next.next;
                return;
            }
            root = root.next;
        }
    }


    public boolean erDelmengdeAv(LenketMengde annenMengde) {
        Node root = head;
        while (root != null) {
            if (!annenMengde.inneholder(root.data)) {
                return false;
            }
            root = root.next;
        }
        return true;
    }


    public boolean erLik(LenketMengde annenMengde) {
        Node temp = head;
        while (temp != null) {
            if (!annenMengde.inneholder(temp.data)) {
                return false;
            }
            temp = temp.next;
        }
        temp = annenMengde.head;
        while (temp != null) {
            if (!inneholder(temp.data)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }





}
