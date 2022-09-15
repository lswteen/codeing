package com.codeing.code.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddTwoNumbersTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode node = answer;

        int carry = 0;  //반올림
        while(null!=l1 || null !=l2){
            int sum = carry;

            if(l1 !=null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum/10;
            sum %= 10;

            ListNode temp = new ListNode(sum);
            node.next = temp;
            node = node.next;
        }

        if(carry > 0){
            ListNode temp = new ListNode(carry);
            node.next = temp;
        }
        return answer.next;
    }

    ListNode reverse(ListNode node) {
        ListNode prev=null;
        while( node!=null ) {
            ListNode tmp=node.next;
            node.next=prev;
            prev=node;
            node=tmp;
        }
        return prev;
    }

    ListNode get(int[] data) {
        ListNode root=new ListNode(data[0]);
        ListNode node=root;
        for (int i = 1; i < data.length; i++) {
            node.next=new ListNode(data[i]);
            node=node.next;
        }
        return root;
    }

    // input: linked list of digits backwards
    BigInteger toInt(ListNode node) {
        BigInteger result=BigInteger.ZERO;
        int pow=0;
        while(node!=null ) {
            BigInteger multiplier=BigInteger.valueOf(10);
            multiplier=multiplier.pow(pow);
            result=result.add(BigInteger.valueOf(node.val).multiply(multiplier));
            node=node.next;
            pow++;
        }
        return result;
    }

    @Test
    void addTwoNumbersTest() {
        //2,4,3
        //5,6,4
        ListNode l1 = reverse(get(new int[]{3,4,2}));
        ListNode l2 = reverse(get(new int[]{4,6,5}));
        ListNode answer = addTwoNumbers(l1,l2);

        System.out.println("answer : " + toInt(answer));

        assertEquals(new BigInteger("807"),toInt(addTwoNumbers(l1,l2)) );

        //9,9,9,9,9,9,9
        //9,9,9,9
        //8,9,9,9,0,0,0,1
    }
}