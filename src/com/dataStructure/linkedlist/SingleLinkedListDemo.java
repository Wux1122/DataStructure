package com.dataStructure.linkedlist;

import static com.dataStructure.linkedlist.SingleLinkedList.getLength;
import static com.dataStructure.linkedlist.SingleLinkedList.reverseList;
import static com.dataStructure.linkedlist.SingleLinkedList.findLastIndexNode;


public class SingleLinkedListDemo {
    public static void main(String[] args) {

        int index = 2;

        BeatlesNode node1 = new BeatlesNode(1, "Paul");
        BeatlesNode node2 = new BeatlesNode(2, "John");
        BeatlesNode node3 = new BeatlesNode(3, "Ringo");
        BeatlesNode node4 = new BeatlesNode(4, "George");

        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(node1);
//        linkedList.add(node2);
//        linkedList.add(node3);
//        linkedList.add(node4);

        linkedList.addByOrder(node4);
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);

        linkedList.list();
        System.out.println("=======================================");

        BeatlesNode newNode = new BeatlesNode(1, "PuppyEyePaul");
        linkedList.update(newNode);
        linkedList.list();
        System.out.println("=======================================");

        linkedList.delete(1);
        linkedList.list();

        System.out.println("=======================================");
        System.out.println("有效的节点个数："+ getLength(linkedList.getHead()));
        System.out.println("=======================================");
        System.out.println("倒数第"+index+"个结点为： "+
                findLastIndexNode(linkedList.getHead(),index));

        System.out.println("=======================================");
        reverseList(linkedList.getHead());
        linkedList.list();

    }
}


class SingleLinkedList{

    private BeatlesNode head = new BeatlesNode(0,"");

    public BeatlesNode getHead(){
        return head;
    }

    public void add(BeatlesNode beatlesNode){
        BeatlesNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }

            temp = temp.next;
        }

        temp.next = beatlesNode;
    }

    public void addByOrder(BeatlesNode beatlesNode){
        BeatlesNode temp = head;
        boolean flag=false;

        while (true){
            if(temp.next==null){
                break;
            }

            if(temp.next.no > beatlesNode.no){
                break;
            }else if(temp.next.no == beatlesNode.no){
                flag = true;
                break;
            }
            temp=temp.next;
        }

        if(flag){
            System.out.println("The node has already exist");
        }else {
            beatlesNode.next=temp.next;
            temp.next=beatlesNode;
        }

    }

    public void update(BeatlesNode newNode){
        BeatlesNode temp = head;
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
        BeatlesNode temp = head;
        boolean flag = false;
        if(head.next == null){
            System.out.println("The linked list is empty");
        }

        while (true){
            if(temp.next == null){
                break;
            }

            if(temp.next.no == no){
                flag =true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("No such node");
        }
    }

    public static int getLength(BeatlesNode head){
        if(head.next == null){
            return 0;
        }

        int length = 0;

        BeatlesNode cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        return length;
    }

    public static BeatlesNode findLastIndexNode(BeatlesNode head,int index){
        if(head.next == null){
            return null;
        }

        int size = getLength(head);

        BeatlesNode cur = head.next;

        if(index <= 0 || index>size){
            return null;
        }

        for (int i = 0; i <size-index ; i++) {
            cur = cur.next;
        }

        return cur;

    }

    public static void reverseList(BeatlesNode head){
        if(head.next == null || head.next.next == null){
            return ;
        }

        BeatlesNode cur = head.next;
        BeatlesNode next = null;
        BeatlesNode reverseHead = new BeatlesNode(0,"");

        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public void list() {
        BeatlesNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }


}

class BeatlesNode{
    public int no;
    public String name;
    public BeatlesNode next;

    public BeatlesNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeatlesNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}