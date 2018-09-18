import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //GC List
    //-XX:+UseSerialGC
    //-XX:+UseParallelGC -XX:+UseParallelOldGC
    //-XX:+UseParNewGC -XX:+UseConcMarkSweepGC
    //-XX:+UseG1GC

    //VM Params
    /*
     -agentlib:jdwp=transport=dt_socket,address=14000,server=y,suspend=n
     -Xms512m
     -Xmx512m
     -XX:MaxMetaspaceSize=256m
     -XX:+CMSParallelRemarkEnabled
     -XX:+UseCMSInitiatingOccupancyOnly
     -XX:CMSInitiatingOccupancyFraction=70
     -XX:+ScavengeBeforeFullGC
     -XX:+CMSScavengeBeforeRemark
     -verbose:gc
     -Xloggc:./logs/gc_pid_%p.log
     -XX:+PrintGCDateStamps
     -XX:+PrintGCDetails
     -XX:+UseGCLogFileRotation
     -XX:NumberOfGCLogFiles=10
     -XX:GCLogFileSize=1M
     -Dcom.sun.management.jmxremote.port=15000
     -Dcom.sun.management.jmxremote.authenticate=false
     -Dcom.sun.management.jmxremote.ssl=false
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=./dumps/

     jps -- list vms or ps -e | grep java
     jstack <pid> >> threaddumps.log -- get dump from pid
     jinfo -- list VM parameters
     jhat / jvisualvm -- analyze heap dump
    */
    public static void main(String[] args) throws Exception{
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        List<List<Object>> globalList = new ArrayList<>();
        GlobalPropertiesMBean globalProps = new GlobalProperties();
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("test:type=MyProps");
        mBeanServer.registerMBean(globalProps, objectName);

        //change by jconsole
        globalProps.setSize(5_000_000);
        globalProps.setSaveGlobal(false);
        globalProps.setSleepTime(1000); // 1s

        while (true) {
            int i = globalProps.getSize();
            System.out.println("Local Counter = " + i);
            System.out.println("Save Global= " + globalProps.getSaveGlobal());
            System.out.println("Sleep Time = " + globalProps.getSleepTime());
            List<Object> localList = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                localList.add(i);
            }

            if (globalProps.getSaveGlobal())
                globalList.add(localList);

            Thread.sleep(globalProps.getSleepTime());
        }
    }
}
