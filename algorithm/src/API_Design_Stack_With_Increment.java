/*
https://leetcode.com/problems/design-a-stack-with-increment-operation/submissions/

use increment array -> use an index cur to maintain the increment of [0, cur] -> arr[cur] = increment number

错误：
1. index的定义
(1)开始定义了index和increment index，两个变量造成逻辑混乱，pop()写起来及其复杂
(2)index的初始值：开始定义为0， 这样就需要多加 index == 0 ？的判断，逻辑混乱->出错
   index初始为-1的好处：每次push的时候，都可以先index++，再对新的stack[index]赋值 -> 统一操作 -> 类似于dummy
***  index最终定义是：stack的顶端元素所在的位置 -> array的tail  ***

2. increment()里：没有考虑到 index < k的情况，造成increment错误。
    如果index < k,那么无论k有多大，都只能increment index个元素

3. pop(): (1) need to "move" the value from [index] to [index - 1] if (index - 1 >= 0) -> index > 0
          (2) set return value always = stack[index] + increment[index] —> 可以省略 increment[index] = 0?的判断
          (3) increment[index]需要还原成0，因为，update的时候，increment[index] += val，如果不还原在：
["CustomStack","increment","push","increment","pop","increment","increment","pop","increment","push","pop","pop"]
[[169],[8,26],[83],[10,75],[],[5,88],[9,99],[],[8,50],[41],[],[]]
test case中，pop()出所有元素之后，increment[]会继续增加，从而再次push() + pop()时，会把之前increment()的数值加进最终结果
而当stack为空时，increment[]不应出现任何变化
***  increment[index]定义：[0,index]所有元素都+val  ***
          (4) index--，以保证，如果stack为空，index 必须 = -1

方法总结：
1. 一定要明确物理意义：index的定义最终是：stack的顶端元素所在的位置 -> array的tail
2. 正确的代码，一定是代码简洁、逻辑清晰的。逻辑不清晰，写出来一定不对。
3. 如果统一操作可以省略判断 -> 统一操作 -> 判断越多，越容易出错
4.
*/
package algorithm.src;

public class API_Design_Stack_With_Increment {
    private int[] stack;
    private int[] increment;
    private int maxSize;
    private int index = -1;//stack top

    public API_Design_Stack_With_Increment(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
    }

    public void push(int x) {
        if (index == maxSize - 1) return;
        else stack[++index] = x;
    }

    public int pop() {
        if (index == -1) return -1;
        if (index > 0) increment[index - 1] += increment[index]; //make value index - 1 of index value
        int popEle = increment[index] + stack[index];//return value
        increment[index] = 0; //MUST setto zero
        //increment[index]定义：[0,index]所有元素都+val
        // pop()之后，只有[0, index - 1]所有元素+val，如果不还原，违背了increment[index]的物理意义
        //stack[index--] = 0;
        index--;
        return popEle;
    }

    public void increment(int k, int val) {
        if (index == -1) return;
        if (k >= maxSize || index <= k - 1) increment[index] += val;
        else increment[k - 1] += val;
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
