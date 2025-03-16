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
            if (head == null) {
                head = nyNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nyNode;
            }
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

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
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
        Node root = head;
        while (root != null) {
            if (!annenMengde.inneholder(root.data)) {
                return false;
            }
            root = root.next;
        }
        root = annenMengde.head;
        while (root != null) {
            if (!inneholder(root.data)) {
                return false;
            }
            root = root.next;
        }
        return true;
    }

    public boolean erDisjunkte(LenketMengde annenMengde) {
        Node root = head;
        while (root != null) {
            if (annenMengde.inneholder(root.data)) {
                return false;
            }
            root = root.next;
        }
        return true;
    }

    public LenketMengde snitt(LenketMengde annenMengde) {
        LenketMengde snittMengde = new LenketMengde();
        Node root = head;
        while (root != null) {
            if (annenMengde.inneholder(root.data)) {
                snittMengde.leggTil(root.data);
            }
            root = root.next;
        }
        return snittMengde;
    }

    public LenketMengde union(LenketMengde annenMengde) {
        LenketMengde unionMengde = new LenketMengde();

        Node root = head;
        while (root != null) {
            unionMengde.leggTil(root.data);
            root = root.next;
        }

        root = annenMengde.head;
        while (root != null) {
            unionMengde.leggTil(root.data);
            root = root.next;
        }

        return unionMengde;
    }


    public LenketMengde differanse(LenketMengde annenMengde) {
        LenketMengde differanseMengde = new LenketMengde();

        Node root = head;
        while (root != null) {
            if (!annenMengde.inneholder(root.data)) {
                differanseMengde.leggTil(root.data);
            }
            root = root.next;
        }
        return differanseMengde;
    }










}
