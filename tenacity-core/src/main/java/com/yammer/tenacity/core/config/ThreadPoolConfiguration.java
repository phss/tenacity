package com.yammer.tenacity.core.config;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ThreadPoolConfiguration {

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int threadPoolCoreSize = 10;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int keepAliveTimeMinutes = 1;

    @Min(-1)
    @Max(Integer.MAX_VALUE)
    private int maxQueueSize = -1;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int queueSizeRejectionThreshold = 5;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int metricsRollingStatisticalWindowInMilliseconds = 10000;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int metricsRollingStatisticalWindowBuckets = 10;

    public ThreadPoolConfiguration() { /* Jackson */ }


    public ThreadPoolConfiguration(int threadPoolCoreSize,
                                   int keepAliveTimeMinutes,
                                   int maxQueueSize,
                                   int queueSizeRejectionThreshold,
                                   int metricsRollingStatisticalWindowInMilliseconds,
                                   int metricsRollingStatisticalWindowBuckets) {
        this.threadPoolCoreSize = threadPoolCoreSize;
        this.keepAliveTimeMinutes = keepAliveTimeMinutes;
        this.maxQueueSize = maxQueueSize;
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
        this.metricsRollingStatisticalWindowInMilliseconds = metricsRollingStatisticalWindowInMilliseconds;
        this.metricsRollingStatisticalWindowBuckets = metricsRollingStatisticalWindowBuckets;
    }

    public int getThreadPoolCoreSize() {
        return threadPoolCoreSize;
    }

    public int getKeepAliveTimeMinutes() {
        return keepAliveTimeMinutes;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public int getQueueSizeRejectionThreshold() {
        return queueSizeRejectionThreshold;
    }

    public int getMetricsRollingStatisticalWindowInMilliseconds() {
        return metricsRollingStatisticalWindowInMilliseconds;
    }

    public int getMetricsRollingStatisticalWindowBuckets() {
        return metricsRollingStatisticalWindowBuckets;
    }

    public void setThreadPoolCoreSize(int threadPoolCoreSize) {
        this.threadPoolCoreSize = threadPoolCoreSize;
    }

    public void setKeepAliveTimeMinutes(int keepAliveTimeMinutes) {
        this.keepAliveTimeMinutes = keepAliveTimeMinutes;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public void setQueueSizeRejectionThreshold(int queueSizeRejectionThreshold) {
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
    }

    public void setMetricsRollingStatisticalWindowInMilliseconds(int metricsRollingStatisticalWindowInMilliseconds) {
        this.metricsRollingStatisticalWindowInMilliseconds = metricsRollingStatisticalWindowInMilliseconds;
    }

    public void setMetricsRollingStatisticalWindowBuckets(int metricsRollingStatisticalWindowBuckets) {
        this.metricsRollingStatisticalWindowBuckets = metricsRollingStatisticalWindowBuckets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreadPoolConfiguration that = (ThreadPoolConfiguration) o;

        if (keepAliveTimeMinutes != that.keepAliveTimeMinutes) return false;
        if (maxQueueSize != that.maxQueueSize) return false;
        if (metricsRollingStatisticalWindowBuckets != that.metricsRollingStatisticalWindowBuckets) return false;
        if (metricsRollingStatisticalWindowInMilliseconds != that.metricsRollingStatisticalWindowInMilliseconds)
            return false;
        if (queueSizeRejectionThreshold != that.queueSizeRejectionThreshold) return false;
        if (threadPoolCoreSize != that.threadPoolCoreSize) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = threadPoolCoreSize;
        result = 31 * result + keepAliveTimeMinutes;
        result = 31 * result + maxQueueSize;
        result = 31 * result + queueSizeRejectionThreshold;
        result = 31 * result + metricsRollingStatisticalWindowInMilliseconds;
        result = 31 * result + metricsRollingStatisticalWindowBuckets;
        return result;
    }

    @Override
    public String toString() {
        return "ThreadPoolConfiguration{" +
                "threadPoolCoreSize=" + threadPoolCoreSize +
                ", keepAliveTimeMinutes=" + keepAliveTimeMinutes +
                ", maxQueueSize=" + maxQueueSize +
                ", queueSizeRejectionThreshold=" + queueSizeRejectionThreshold +
                ", metricsRollingStatisticalWindowInMilliseconds=" + metricsRollingStatisticalWindowInMilliseconds +
                ", metricsRollingStatisticalWindowBuckets=" + metricsRollingStatisticalWindowBuckets +
                '}';
    }

}
