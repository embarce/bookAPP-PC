package com.neusoft.security.core.validate;

import com.neusoft.security.core.validate.exception.ValidateCodeException;
import com.neusoft.security.core.validate.processor.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>校验码处理器管理器</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ValidateCodeProcessorHolder {

    private final Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * Instantiates a new Validate code processor holder.
     *
     * @param validateCodeProcessors the validate code processors
     */
    @Autowired
    public ValidateCodeProcessorHolder(Map<String, ValidateCodeProcessor> validateCodeProcessors) {
        this.validateCodeProcessors = validateCodeProcessors;
    }

    /**
     * Find validate code processor validate code processor.
     *
     * @param type the type
     * @return validate code processor
     */
    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    /**
     * Find validate code processor validate code processor.
     *
     * @param type the type
     * @return validate code processor
     */
    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
