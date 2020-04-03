package com.kit.schedule;

import com.kit.format.StringType;

import java.math.BigDecimal;

/**
 * Created by kk on 2020/4/2.
 */
public class RequestStat implements StringType {

    private Long max;//时间范围内的最大相应时长
    private Long min;//时间范围内的最小相应时长
    private BigDecimal avg;//时间范围内的平均相应时长
    private Integer count;//时间范围内的相应个数
    private Long percent9;//时间范围内的90%的相应时长
    private BigDecimal tps;//时间范围内的的请求率

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPercent9() {
        return percent9;
    }

    public void setPercent9(Long percent9) {
        this.percent9 = percent9;
    }

    public BigDecimal getTps() {
        return tps;
    }

    public void setTps(BigDecimal tps) {
        this.tps = tps;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "[max="+max+";min="+min+";avg="+avg+";count="+count+";percent9="+percent9+";tps="+tps+"]";
    }

    @Override
    public String formatString() {
        return toString();
    }
}
