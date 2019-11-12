package method.inefficient;

/**
 * @author Seagull_gby
 * @date 2019/11/12 11:10
 * Description: 剑指Offer-面试题05-Java实现
 *
 * 问题描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 实现思路：
 * 用一个新的动态字符串来存储值，遍历原字符串将字符复制到动态字符串中，如果遇到空格就在动态字符串中追加"%20"
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
        /* 构造可变长最终字符串 */
        StringBuilder fstr = new StringBuilder();

        /* 循环遍历目标字符串，将字符复制到最终字符串中，遇到空格则追加"%20" */
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                fstr.append("%20");
            } else {
                fstr.append(str.charAt(i));
            }
        }

        return fstr.toString();
    }
}
