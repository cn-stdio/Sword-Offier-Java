package method.third;

/**
 * @author Seagull_gby
 * @date 2019/11/11 13:58
 * Description: 剑指Offer-面试题02-Java实现
 *
 * 问题描述：
 * 设计一个类，我们只能生成该类的一个实例
 *
 * 实现方法：懒汉式实现单例模式
 * 性能得到提升但非线程安全
 */
class Singleton {
    /**
     * private限定外部访问，而static保证只存在一个该实例。
     */
    private static Singleton instance;

    /**
     * 构造方法使用private限定外部实例化该类
     */
    private Singleton(){}

    /**
     * 实例的全局访问点
     * @return 唯一实例
     */
    public static Singleton getInstance() {
        /* 如果没有实例化就实例化，否则返回已有实例 */
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
