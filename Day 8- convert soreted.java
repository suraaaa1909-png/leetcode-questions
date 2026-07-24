class Solution {
    private TreeNode helper(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if(head == tail) return null;

        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = helper(head, slow);
        treeHead.right = helper(slow.next, tail);
        return treeHead;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
}
