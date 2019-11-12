package method.features;

/**
 * @author Seagull_gby
 * @date 2019/11/12 15:15
 * Description: 剑指Offer-面试题05-Java实现
 *
 * 问题描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 实现思路：
 * 利用了Java自己封装的字符串方法直接返回。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

public class Solution {

    /**
     * 字符串中空格替换为"%20"
     * @param str 字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
