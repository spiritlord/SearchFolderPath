package search1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索指定路径下的文件夹或文件
 *
 * @author gaohao
 * @date 2019/12/12 17:03
 * @desc
 */
public class SearchFolderUtils {

    /**
     * 判断是否包含子文件或子文件夹。
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:08
     */
    private static boolean isHasChildren(final File f) {
        boolean flag = false;
        File[] list = null;
        if (f.isDirectory()) {
            list = f.listFiles();
        }
        if (null != list && list.length > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 搜索文件夹或文件
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:08
     */
    public static List<File> search(final String folderPath, final FileFilter fileFilter) {
        File folder = new File(folderPath);

        ArrayList<File> result = new ArrayList<>();

        // 树中当前层节点的集合
        ArrayList<File> currentLevelNodes = new ArrayList<>();
        currentLevelNodes.add(folder);

        // 判断当前层是否有节点
        while (currentLevelNodes.size() > 0) {
            // 下一层节点的集合
            ArrayList<File> nextLevelNodes = new ArrayList<>();
            // 找到树中所有的下一层节点，并把这些节点放到 nextLevelNodes 中
            for (File f : currentLevelNodes) {
                // 如果符合过滤条件，就放到返回结果里面
                if (fileFilter.filter(f)) {
                    result.add(f);
                }
                // 如果有子节点，就把子节点加入 nextLevelNodes
                if (isHasChildren(f)) {
                    for (File childFile : f.listFiles()) {
                        nextLevelNodes.add(childFile);
                    }
                }
            }

            // 令当前层节点集合的引用指向下一层节点的集合
            currentLevelNodes = nextLevelNodes;
        }

        result.trimToSize();
        return result;
    }
}
