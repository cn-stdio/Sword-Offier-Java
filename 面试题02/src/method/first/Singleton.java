package method.first;

/**
 * @author Seagull_gby
 * @date 2019/11/11 13:48
 * Description: 剑指Offer-面试题02-Java实现
 *
 * 问题描述：
 * 设计一个类，我们只能生成该类的一个实例
 *
 * 实现方法：静态内部类实现单例模式（推荐）
 * 线程安全且性能得到优化
 */
public class Singleton {
    /**
     * 构造方法使用private限定外部实例化该类
     */
    private Singleton(){}

    /**
     * 静态内部私有类
     * 在第一次加载时初始化并创建实例
     */
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    /**
     * 实例的全局访问点
     * @return 唯一实例
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
