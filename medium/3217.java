import java.util.HashSet;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        if (head == null)
            return head;
        ListNode temp = null;
        ListNode prev = null;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums)
            set.add(i);

        while (head != null && set.contains(head.val)) 
            head = head.next;
        
        temp=  head;
        prev = head;

        while (temp!=null) {
            if(set.contains(temp.val))
            {
               prev.next = temp.next;
               temp=temp.next;
            }

            else{
                prev = temp;
                temp=temp.next;
            }
            
        }    

        return head;
    }
}