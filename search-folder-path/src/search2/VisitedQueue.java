package search2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaohao
 * @date 2019/12/12 17:45
 * @desc
 */
public class VisitedQueue {

    /**
     * 已经访问的文件夹集合
     */
    private Set<FileTreeNode> visitedQueue = new HashSet<>();

    /**
     * 将访问过的文件夹添加到visitedQueue中
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:46
     */
    public void addVisitedFolder(FileTreeNode fileNode) {
        visitedQueue.add(fileNode);
    }

    /**
     * 移除访问过的文件夹
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:46
     */
    public void removeVisitedFolder(FileTreeNode fileNode) {
        visitedQueue.remove(fileNode);
    }

    /**
     * 判断文件上是否在集合中
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:46
     */
    public boolean isContainment(FileTreeNode fileNode) {
        return visitedQueue.contains(fileNode);
    }

    /**
     * 判断队列是否为空
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:46
     */
    public boolean IsEmpty() {
        return visitedQueue.isEmpty();
    }
}
