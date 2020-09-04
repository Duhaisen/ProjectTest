package Active;

public interface ActivityFilter<M> {

    default boolean filter(M m){
        return true;
    }

}
