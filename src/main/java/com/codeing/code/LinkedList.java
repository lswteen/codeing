package com.codeing.code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LinkedList {
    Node head;

    //node 구성
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //insert node
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }


    //검색하는 node
    public int findLarge(int k){
        if(head == null){
            return -1;
        }

        //내림차순 정렬 우선순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Node currnetNode = head;

        //링크드 리스트 원소 큐에 삽입
        while(currnetNode !=null){
            queue.offer(currnetNode.data);
            currnetNode = currnetNode.next;
        }

        //k번째 큰 값 찾기
        int klarge = -1;
        for(int i = 0; i< k;i++){
            if(!queue.isEmpty()){
                klarge = queue.poll();
            }else{
                break;
            }
        }
        return klarge;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(1);
        list.insert(4);
        list.insert(2);
        int k =2;
        int klarge = list.findLarge(k);
        System.out.println(k+" 번째 큰수 : "+ klarge);
    }

}
