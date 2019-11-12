package method.second;

/**
 * @author Seagull_gby
 * @date 2019/11/11 13:48
 * Description: 剑指Offer-面试题02-Java实现
 *
 * 问题描述：
 * 设计一个类，我们只能生成该类的一个实例
 *
 * 实现方法：饿汉式实现单例模式
 * 线程安全但性能浪费
 */
class Singleton {

    /**
     * private限定外部访问，而static保证只存在一个该实例。
     * 在初始化的时候就创建实例
     */
    private static Singleton instance = new Singleton();

    /**
     * 构造方法使用private限定外部实例化该类
     */
    private Singleton(){}

    /**
     * 实例的全局访问点
     * @return 唯一实例
     */
    public static Singleton getInstance() {
        return instance;
    }
}

