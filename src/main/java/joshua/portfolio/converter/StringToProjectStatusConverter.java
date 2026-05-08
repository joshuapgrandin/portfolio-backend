package joshua.portfolio.converter;

import joshua.portfolio.projects.enums.ProjectStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToProjectStatusConverter implements Converter<String, ProjectStatus> {

    @Override
    public ProjectStatus convert(String value) {
        return ProjectStatus.valueOf(value.toUpperCase());
    }
}
