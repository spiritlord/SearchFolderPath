package search2;

import java.io.File;
import java.util.LinkedList;

/**
 * 文件队列,保存所遍历的文件
 *
 * @author gaohao
 * @date 2019/12/12 17:41
 * @desc
 */
public class FileQueue {

    private LinkedList<FileTreeNode> fileQueue = new LinkedList<FileTreeNode>();

    /**
     * 加入队列
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:42
     */
    public void AddToQueue(FileTreeNode fileNode) {
        fileQueue.addLast(fileNode);
    }

    /**
     * 添加一个File数组到队列中
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:42
     */
    public void AddFileListToQueue(File[] files, FileTreeNode fn) {
        FileTreeNode fileNode;

        for (File file : files) {
            if (file.canRead() && !file.getName().equals("$RECYCLE.BIN")
                    && !file.getName().equals("RECYCLER")
                    && !file.getName().equals("System Volume Information")) {
                fileNode = new FileTreeNode();
                fileNode.setFile(file);
                fileNode.setIsHidden(file.isHidden());
                fileNode.setParent(fn);
                fileNode.setRank(fn.getRank() + 1);
                fileNode.setRoom(file);

                AddToQueue(fileNode);
            }
        }
    }

    /**
     * 出队列
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:42
     */
    public FileTreeNode RemoveFromQueue() {
        return fileQueue.removeFirst();
    }

    /**
     * 判断队列是否为空
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:43
     */
    public boolean IsEmpty() {
        return fileQueue.isEmpty();
    }

    /**
     * 判断队列中是否包含了filenode
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:43
     */
    public boolean ContainFile(FileTreeNode fileNode) {
        return fileQueue.contains(fileNode);
    }
}
