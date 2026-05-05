package joshua.portfolio.projects.util;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringArrayConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] array) {
        return array == null ? null : String.join(",", array);
    }

    @Override
    public String[] convertToEntityAttribute(String dbValue) {
        return dbValue == null ? new String[0] : dbValue.split(",");
    }
}