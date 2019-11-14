import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Seagull_gby
 * @date 2019/11/14 15:16
 * Description: 剑指Offer-面试题09-Java实现
 *
 * 问题描述：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 实现思路：
 * 每次压入的时候压入到栈A中。
 * 弹出时判断栈B是否为空栈。
 * 如果是空栈，就将栈A的元素分别弹出并压入到栈B中，这样栈B中保存的元素顺序正好和栈A相反，从栈B弹出即为最先压入的值。
 * 如果不是空栈，直接弹出即可，因为栈B中保存的一定是最先压入的几个值。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    /**
     * 声明两个栈并初始化
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 用两个栈实现队列的压入操作
     * @param node 要压入队列的值
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 用两个栈实现队列的弹出操作
     * @return 弹出的值
     */
    public int pop() {
        /* 栈B不为空则直接弹出，为空就把栈A的元素“倒”到栈B，再弹出 */
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        /* 在空队列删除元素抛出异常 */
        if(stack2.empty()) {
            throw new EmptyStackException();
        }

        return stack2.pop();
    }
}
