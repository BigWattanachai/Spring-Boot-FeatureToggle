package com.example.featureToggle;

import com.example.featureToggle.config.FeatureToggleConfig;
import com.example.featureToggle.exception.FeatureNotImplementedException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Aspect
public class FeatureToggleAspect {
    @Before(value = "@annotation(featureToggle)")
    public void toggle(FeatureToggle featureToggle) throws Throwable {
        String feature = FeatureToggleConfig.getProperty(featureToggle.feature());
        if (!StringUtils.isEmpty(feature)) {
            Boolean isEnable = Boolean.parseBoolean(feature);
            if (!isEnable) {
                throw new FeatureNotImplementedException("This feature is not available.");
            }
        }
    }
}
