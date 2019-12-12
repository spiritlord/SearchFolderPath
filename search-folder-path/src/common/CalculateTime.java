package common;

/**
 * 时间处理类
 *
 * @author gaohao
 * @date 2019/12/12 17:22
 * @desc
 */
public class CalculateTime {

    private static final Integer INTERVAL = 3600;

    /**
     * 计算程序运行时间
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:22
     */
    public static String calculateTraversalTime(long time) {
        if (INTERVAL > time) {
            return "花费" + time + "毫秒";
        } else if (INTERVAL * INTERVAL > time) {
            return "花费" + time / INTERVAL + "秒";
        } else {
            return "花费" + time / INTERVAL / INTERVAL + "分钟";
        }
    }
}
