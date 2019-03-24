# leetcode代码

## 两数相加

> 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

> 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

> 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

### 我的代码

```C
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *d1 = l1,*d2 = l2,*p,*q,*k,*s;
    s = p = q = (struct ListNode*) malloc(sizeof(struct ListNode));
    int cp = 0,loop = 0;
    while(d1 != NULL && d2 != NULL){
        
        int value = d1 -> val + d2 -> val + cp;
        // 计算出进位和该位余下的数
        cp = value /10,loop = value % 10;
        d1 = d1 -> next;
        d2 = d2 -> next;
        // 赋值
        q -> val = loop;
        // 创建新节点
        q -> next = (struct ListNode*) malloc(sizeof(struct ListNode));
        p = q;
        q = q -> next;
        
    }
    k = d1 == NULL ? d2:d1;
    while (k != NULL){
        int value = k -> val + cp;
        cp = value /10,loop = value % 10;
        q -> val = loop;
        q -> next = (struct ListNode*) malloc(sizeof(struct ListNode));
        p = q;
        q = q -> next;
        k = k -> next;
    }
    if(cp != 0){
        q -> val = 1;
        p = p -> next;
    }else{
        free(p -> next);
    }
    p -> next = NULL;
    q = NULL;
    return s;
}
```

### 官方给的代码
```Java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
```

### 总结

> 没能把不存在高位的数的高位转化成数值0进行处理，需要注意（我的代码臃肿不堪，而且可读性特别低）。