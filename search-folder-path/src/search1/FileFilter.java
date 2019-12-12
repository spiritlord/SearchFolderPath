package search1;

import java.io.File;

/**
 * 条件过滤接口
 *
 * @param
 * @author gaohao
 * @date 2019/12/12 17:09
 * @return
 */
public interface FileFilter {

    /**
     * 回调函数
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:09
     */
    boolean filter(File file);
}
