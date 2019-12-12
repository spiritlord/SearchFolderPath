import common.CalculateTime;
import search1.SearchFolderUtils;
import search2.CrawlFolder;

import java.io.File;
import java.time.Instant;
import java.util.List;

/**
 * 测试方法
 *
 * @author gaohao
 * @date 2019/12/12 17:10
 * @desc
 */
public class SearchTest {

    public static void main(String[] args) {
        String path = "C:/soft";
        search1(path);
        search2(path);
    }

    /**
     * search1测试方法
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:54
     */
    private static void search1(String path) {
        long time = Instant.now().toEpochMilli();
        List<File> list = SearchFolderUtils.search(path, f -> {
            // 筛选文件夹或文件
            if (f.getName().endsWith("r")) {
                return true;
            }
            return false;
        });
        list.forEach(f -> System.out.println(f.getPath()));
        System.out.println(CalculateTime.calculateTraversalTime(Instant.now().toEpochMilli() - time));
    }

    /**
     * search2测试方法
     *
     * @param
     * @return
     * @author gaohao
     * @date 2019/12/12 17:55
     */
    private static void search2(String path) {
        long time = Instant.now().toEpochMilli();
        CrawlFolder.traversalFolders(path);
        System.out.println(CalculateTime.calculateTraversalTime(Instant.now().toEpochMilli() - time));
    }
}
