package com.peihua.tset;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

public class ZoopkeeperTest {

    private static String connectString = "192.168.197.20:2182,192.168.197.20:2183,192.168.197.20:2184";
    private static int sessionTimeout = 60000;
    ZooKeeper zkClient = null;
    @Before
    public void init() throws Exception {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            public void process(WatchedEvent event) {

                // 收到事件通知后的回调函数（用户的业务逻辑）
                System.out.println(event.getType() + "--" + event.getPath());

                // 再次启动监听
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void test1(){
        // 参数1：要创建的节点的路径； 参数2：节点数据 ； 参数3：节点权限 ；参数4：节点的类型
        /*权限说明：
        OPEN_ACL_UNSAFE  : 完全开放的ACL，任何连接的客户端都可以操作该属性znode
        CREATOR_ALL_ACL : 只有创建者才有ACL权限
        READ_ACL_UNSAFE：只能读取ACL
*/
        try {
            String nodeCreated = zkClient.create("/peihua", "xian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zkClient"+zkClient);

    }

}
