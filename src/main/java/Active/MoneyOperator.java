package Active;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoneyOperator {

    private Map<String, BigDecimal> operatorMap;

    private static final int DEFAULT_ROUND = BigDecimal.ROUND_HALF_UP;

    private static final int DEFAULT_SCALE = 2;


    public MoneyOperator(Map<String, BigDecimal> operatorMap) {
        this.operatorMap = operatorMap;
    }

    public MoneyOperator(String key, BigDecimal decimal) {
        operatorMap = new HashMap<>();
        operatorMap.put(key, decimal);
    }

    public MoneyOperator(String key, String decimal) {
        this(key,new BigDecimal(decimal));
    }

    /**
     * 控制不能出现 比源数据大 和 小于零 的数据
     * */
    public BigDecimal doOperator(BigDecimal source) {
        if (operatorMap != null && operatorMap.keySet().size() == 1) {
            Set<Map.Entry<String, BigDecimal>> entries = operatorMap.entrySet();
            Map.Entry<String, BigDecimal> firstEntity = entries.iterator().next();
            String operatorKey = firstEntity.getKey();
            BigDecimal operatorBigDecimal = firstEntity.getValue();

            BigDecimal target = BigDecimal.ZERO;

            if (operatorKey.equals(MoneyOperatorEnum.DISCOUNT.getKey())) {
                target = source.multiply(operatorBigDecimal);
            } else if (operatorKey.equals(MoneyOperatorEnum.SUBTRACTION.getKey())) {
                target =  source.subtract(operatorBigDecimal);
            }

            // <=0
            if (target.compareTo(BigDecimal.ZERO)<1){
                return BigDecimal.ZERO;
            }
            // 0< <=source
            if (target.compareTo(source)<1){
                return target;
            }
        }
        return source;
    }

    public BigDecimal doOperator(String source) {
        return this.doOperator(new BigDecimal(source));
    }

    public BigDecimal doOperator(Float floatSource) {
        return this.doOperator(floatSource, DEFAULT_SCALE);
    }

    public BigDecimal doOperator(Float floatSource, int scale) {
        return this.doOperator(floatSource, scale, DEFAULT_ROUND);
    }

    public BigDecimal doOperator(Float floatSource, int scale, int round) {
        return this.doOperator(new BigDecimal(floatSource).setScale(scale, round));
    }

}
