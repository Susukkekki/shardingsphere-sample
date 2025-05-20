package io.sskk.shardingsphere_sample.sharding;

import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class LocationHintAlgorithm implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         HintShardingValue<String> shardingValue) {
        for (String value : shardingValue.getValues()) {
            if ("SEOUL".equalsIgnoreCase(value)) {
                return Collections.singleton("ds0");
            } else if ("BUSAN".equalsIgnoreCase(value)) {
                return Collections.singleton("ds1");
            }
        }
        return Collections.singleton("ds0"); // 기본값
    }

    @Override
    public Properties getProps() {
        return new Properties();
    }

    @Override
    public String getType() {
        return "CLASS_BASED";
    }

    @Override
    public void init(Properties arg0) {        
    }
}
