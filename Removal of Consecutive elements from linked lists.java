class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        int i=0,j=i+1;
        while(arr.size()!=1){
            if((arr.get(i)+arr.get(j))==0){
                arr.remove(i);
                arr.remove(j-1);
                if(arr.size()>1){
                    i=0;
                    j=i+1;
                }
                if(arr.size()==0) break;
            }
            else{
                if(i<arr.size()-2){
                i++;
                j++;
                }else{
                    break;
                }
            }
        }
        System.out.println(arr);
        if(arr.size()==0) return null;
        ListNode newList=new ListNode(0);
        ListNode current = newList;
        
        // Traverse the ArrayList and construct the linked list
        for (int num : arr) {
            ListNode node = new ListNode(num);
            current.next = node;
            current = current.next;
        }
        return newList.next;
    }
}
