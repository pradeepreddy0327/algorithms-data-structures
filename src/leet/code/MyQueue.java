package leet.code;

import java.util.Stack;

class MyQueue {

	/** Initialize your data structure here. */
	Stack<Integer> s;
	Stack<Integer> r;

	public MyQueue() {
		s = new Stack<>();
		r = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		s.push(x);
	}

	public void updateR() {
		while (!s.isEmpty()) {
			r.push(s.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (r.isEmpty())
			updateR();
		return r.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (r.isEmpty())
			updateR();
		return r.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s.isEmpty() && r.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
