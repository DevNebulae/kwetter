package edu.fontys.kwetter.conversion

import java.time.Instant
import java.time.ZonedDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class InstantConverter : AttributeConverter<Instant, String> {
    override fun convertToDatabaseColumn(attribute: Instant): String {
        return attribute.toString()
    }

    override fun convertToEntityAttribute(dbData: String): Instant {
        return ZonedDateTime.parse(dbData).toInstant()
    }
}
