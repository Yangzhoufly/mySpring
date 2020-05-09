package com.fly.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("listNode")
@Scope("prototype")
public class ListNode {
    int val;
    ListNode next;
}
