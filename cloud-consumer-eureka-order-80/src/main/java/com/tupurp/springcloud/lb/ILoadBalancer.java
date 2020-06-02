package com.tupurp.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-02 01:00
 */

@Component
@Slf4j
public class ILoadBalancer implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自旋锁（乐观锁） cas
     *
     * */
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 :current + 1;

            /**AtomicInteger类compareAndSet
             * 通过原子操作实现了CAS(Compare And Set)操作
             * 最底层基于汇编语言实现
             *
             * 1:current (已知当前内存里面的值current) = real (内存中AtomicInteger对象地址对应的真实值)
             * 2:next (预期要修改成的值)
             * 3:传入 current,next
             * 4:内存中AtomicInteger对象地址对应的真实值(因为有可能别修改)real与current对比，
             * 5:相等表示real未被修改过，是“安全”的，将 next 赋给 real 结束然后返回；不相等说明 real 已经被修改，结束并重新执行1直到修改成功
             */

        }while(!this.atomicInteger.compareAndSet(current,next));

        log.info("**** 第 {} 次访问 :",next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}