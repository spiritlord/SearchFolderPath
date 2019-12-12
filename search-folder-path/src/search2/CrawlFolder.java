package search2;

import java.io.File;

/**
 * 遍历文件夹
 *
 * @author gaohao
 * @date 2019/12/12 17:38
 * @desc
 */
public class CrawlFolder {

    /**
     * 访问过的文件夹的集合
     */
    private static VisitedQueue visitedQueue = new VisitedQueue();

    /**
     * 待访问的文件夹的队列
     */
    private static FileQueue fileQueue = new FileQueue();

    /**
     * 遍历文件夹
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:40
     */
    public static void traversalFolders(String path) {
        File root = new File(path);
        FileTreeNode filenode = new FileTreeNode();
        filenode.setFile(root);
        filenode.setIsHidden(root.isHidden());
        filenode.setRank(1);
        filenode.setRoom(root);
        filenode.setParent(filenode);

        // 是文件夹就向下遍历,否则跳出
        if (root.isDirectory()) {
            fileQueue.AddToQueue(filenode);
        } else {
            return;
        }

        while (!fileQueue.IsEmpty()) {
            FileTreeNode fn = fileQueue.RemoveFromQueue();

            // 已经遍历过的文件直接跳过
            if (visitedQueue.isContainment(fn)) {
                return;
            }

            if (fn.getFile().isDirectory()) {
                fileQueue.AddFileListToQueue(fn.getFile().listFiles(), fn);
            }

            showFolderInfo(fn);
        }
    }

    /**
     * 输出文件夹相关的信息
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:41
     */
    private static void showFolderInfo(FileTreeNode filenode) {
        // 等级越高就输出越多个空格
        for (int i = 1; i < filenode.getRank(); i++) {
            System.out.print("==|");
        }
        // 输出文件名称
        System.out.print(filenode.getFileName());

        // 输出文件的等级
        System.out.print("[第" + filenode.getRank() + "级");

        // 输出文件是否为隐藏的
        System.out.print(" - " + filenode.getIsHidden());

        //  输出文件的大小
        System.out.print(" - " + filenode.getRoom() + "]");

        // 输出上级目录
        System.out.println(" [上级目录:" + filenode.getParent().getFile().getName() + "]");
    }
}
