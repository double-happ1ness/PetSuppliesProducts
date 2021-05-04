package petsuppliesproducts;

public class Product implements SortedADT {

    private class ListNode {

        private Comparable object;
        private ListNode next;
    }
    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public String toString() {
        String listDetails = new String();
        if (this.head != null) {
            ListNode current = this.head;
            while (current != null) {
                listDetails += current.object + "\n";
                current = current.next;
            }
        } else {
            listDetails += "list is empty";
        }
        return listDetails;
    }

    public void insert(Comparable object) throws NotUniqueException {
        ListNode newNode = new ListNode();
        newNode.object = object;
        if (this.head == null) {
            this.head = newNode;
        } else {
            ListNode current = this.head;
            // require to explicitly set to null to avoid compilation error
            ListNode previous = null;
            Boolean insertionPositionFound = false;
            while (!insertionPositionFound) {
                if (object.compareTo(current.object) == 0) {
                    throw new NotUniqueException();
                }
                if (object.compareTo(current.object) < 0) {
                    insertionPositionFound = true;
                    newNode.next = current;
                    if (current == this.head) {
                        this.head = newNode;
                    } else {
                        previous.next = newNode;
                        insertionPositionFound = true;
                    }
                } else {
                    if (current.next == null) {
                        insertionPositionFound = true;
                        current.next = newNode;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }
            }
        }
    }

    public Comparable find(Comparable object) throws NotFoundException {
        if (this.head == null) {
            throw new NotFoundException();
        }
        Comparable foundObject = null;
        this.current = this.head;
        while (foundObject == null) {
            if (object.compareTo(this.current.object) == 0) {
                foundObject = this.current.object;
            } else if (object.compareTo(this.current.object) < 0) {
                throw new NotFoundException();
            } else if (this.current.next == null) {
                throw new NotFoundException();
            } else {
                this.previous = this.current;
                this.current = this.current.next;
            }
        }
        return foundObject;
    }

    public Comparable remove(Comparable object) throws NotFoundException {
        Comparable removedObject = find(object);
        if (this.current == this.head) {
            this.head = this.current.next;
        } else {
            this.previous.next = this.current.next;
        }
        this.current.object = null;
        this.current.next = null;
        return removedObject;
    }
}
