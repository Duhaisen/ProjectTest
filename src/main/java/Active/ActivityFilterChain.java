package Active;

import java.util.ArrayList;

public class ActivityFilterChain<M> extends ArrayList<ActivityFilter<M>> {

    public boolean doFilter(M m) {

        for (ActivityFilter<M> e : this) {
            if (!e.filter(m)){
                return false;
            }
            e.filter(m);
        }
        return true;

    }

}
