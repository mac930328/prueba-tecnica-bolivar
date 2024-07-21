package com.bolivar.hexagonal_architecture;

import com.bolivar.hexagonal_architecture.outputs.rest.converters.IdConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class HexagonalArchitectureConfig implements WebMvcConfigurer {

    private final IdConverter idConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(idConverter);
    }
}
