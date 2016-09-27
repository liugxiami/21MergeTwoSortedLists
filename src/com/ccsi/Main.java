package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    ListNode l1=buildList1();
        ListNode l2=buildList2();
        ListNode res=mergeTwoLists(l1,l2);
    }
    //Merge two sorted linked lists and return it as a new list. the new list should be made by splicing together
    //the nodes of the first two lists.
    //1.loop
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode dummyHead=new ListNode(-1);
        ListNode d=dummyHead;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                d.next=l1;
                l1=l1.next;
                d=d.next;
            }else{
                d.next=l2;
                l2=l2.next;
                d=d.next;
            }
        }
        if(l1!=null){
            d.next=l1;
        }else{
            d.next=l2;
        }
        return dummyHead.next;
    }
    //2.recursion    不太理解该方法，为何最后返回的temp是排行序的linkedlist？
    public static ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            ListNode temp=l1;
            temp.next=mergeTwoLists1(l1.next,l2);
            return temp;
        }else{
            ListNode temp=l2;
            temp.next=mergeTwoLists1(l1,l2.next);
            return temp;
        }
    }

    public static ListNode buildList1(){
        ListNode root=new ListNode(1);
        root.next=new ListNode(3);
        root.next.next=new ListNode(5);
        root.next.next.next=new ListNode(7);
        root.next.next.next.next=new ListNode(9);
        return root;
    }
    public static ListNode buildList2(){
        ListNode root=new ListNode(2);
        root.next=new ListNode(4);
        root.next.next=new ListNode(6);
        return root;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
