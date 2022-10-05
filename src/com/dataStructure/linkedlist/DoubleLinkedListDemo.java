package com.dataStructure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        BeatlesNode2 node1 = new BeatlesNode2(1, "Paul");
        BeatlesNode2 node2 = new BeatlesNode2(2, "John");
        BeatlesNode2 node3 = new BeatlesNode2(3, "Ringo");
        BeatlesNode2 node4 = new BeatlesNode2(4, "George");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(node1);
//        doubleLinkedList.add(node2);
//        doubleLinkedList.add(node3);
//        doubleLinkedList.add(node4);

//        doubleLinkedList.list();
        System.out.println("==================================");
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.list();

        System.out.println("==================================");
        BeatlesNode2 newNode = new BeatlesNode2(1, "Puppy");
        doubleLinkedList.update(newNode);
        doubleLinkedList.list();
        System.out.println("==================================");
        doubleLinkedList.delete(2);
        doubleLinkedList.list();


    }
}



class DoubleLinkedList{
    private BeatlesNode2 head = new BeatlesNode2(0,"");

    public BeatlesNode2 getHead() {
        return head;
    }

    public void add(BeatlesNode2 beatlesNode){
        BeatlesNode2 temp = head;
        while (true){
            if(temp.next == null){
                break;
            }

            temp = temp.next;
        }

        temp.next = beatlesNode;
        beatlesNode.pre = temp;
    }

    public void addByOrder(BeatlesNode2 beatlesNode2){
        BeatlesNode2 temp = head.next;
        boolean flag = false;

        while (true){
            if(temp == null){
                break;
            }

            if(temp.no > beatlesNode2.no){
                break;
            }else if(temp.no == beatlesNode2.no){
                flag = true;
                break;
            }

            temp = temp.next;

        }

        if(flag){
            System.out.println("The node has already exist");
        }else if(!flag){
            temp.pre = beatlesNode2;
            beatlesNode2.next = temp;
        }else {
            temp = beatlesNode2;
        }

    }

    public void update(BeatlesNode2 newNode){
        BeatlesNode2 temp = head;
        boolean flag = false;
        if(head.next==null){
            System.out.println("The linked list is empty");
        }

        while (true){
            if(temp.next == null){
                break;
            }

            if(temp.next.no == newNode.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.next.name = newNode.name;
        }else {
            System.out.println("No such node");
        }


    }

    public void delete(int no){
        BeatlesNode2 temp = head.next;
        boolean flag = false;
        if(head.next == null){
            System.out.println("The linked list is empty");
        }

        while (true){
            if(temp == null){
                break;
            }

            if(temp.no == no){
                flag =true;
                break;
            }

            temp = temp.next;
        }

        if(flag){

            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;

        }else {
            System.out.println("No such node");
        }
    }

    public void list() {
        BeatlesNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}



class BeatlesNode2{
public int no;
public String name;
public BeatlesNode2 next;
public BeatlesNode2 pre;

    public BeatlesNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeatlesNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}