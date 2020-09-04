package Active;

import java.math.BigDecimal;
import java.util.Collection;

public abstract class AbstractActivityExecutor {

    private static final MoneyOperator DEFAULT_MONEY_OPERATOR = new MoneyOperator("discount", new BigDecimal("1.00"));

    protected ActivityFilterChain<OrderInfos> activityFilterChain;
    protected MoneyOperator moneyOperator;
    protected OrderInfos orderInfos;
    protected Active active;

    public AbstractActivityExecutor(OrderInfos orderInfos, Active active) {
        this.orderInfos = orderInfos;
        this.active = active;
        this.createDefaultFilterChain();
        this.createMoneyOperatorFromActive();
    }

    public boolean addFilter(ActivityFilter<OrderInfos> activityFilter) {
        return activityFilterChain.add(activityFilter);
    }

    public boolean addFilter(Collection<ActivityFilter<OrderInfos>> activityFilters) {
        return activityFilterChain.addAll(activityFilters);
    }

    public boolean doFilter(OrderInfos orderInfos) {
        return activityFilterChain.doFilter(orderInfos);
    }

    public void doExecutor() {
        if (doFilter(orderInfos)) {
            this.doOrderExecutor();
            this.doOrderDetailExecutor();
        }
    }

    protected abstract void createMoneyOperatorFromActive();

    protected abstract void createDefaultFilterChain();

    protected abstract void doOrderExecutor();

    protected abstract void doOrderDetailExecutor();


}
