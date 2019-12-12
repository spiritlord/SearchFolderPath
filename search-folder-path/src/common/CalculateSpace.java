package common;

import java.io.File;

/**
 * 计算节点大小
 *
 * @author gaohao
 * @date 2019/12/12 17:47
 * @desc
 */
public class CalculateSpace {

    private static final Integer INTERVAL = 1024;

    /**
     * 返回byte的数据大小对应单位
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:47
     */
    public static String CalculateFileSpace(long size, File file) {
        if (0 == size) {
            if (file.isDirectory()) {
                return "文件夹";
            } else {
                return "空";
            }
        } else if (INTERVAL > size) {
            return size + "字节";
        } else if (INTERVAL * INTERVAL > size) {
            return size / INTERVAL + "KB";
        } else if (INTERVAL * INTERVAL * INTERVAL > size) {
            return size / INTERVAL / INTERVAL + "MB";
        } else {
            return size / INTERVAL / INTERVAL / INTERVAL + "GB";
        }
    }
}
