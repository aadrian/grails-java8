package org.grails.plugins.bson.temporal

import org.bson.BsonReader
import org.bson.BsonWriter
import spock.lang.Shared
import spock.lang.Specification
import java.time.LocalDate
import java.time.Month

class ConvertsLocalDateSpec extends Specification implements ConvertsLocalDate {

    @Shared
    LocalDate localDate

    void setupSpec() {
        localDate = LocalDate.of(1941, 1, 5)
    }

    void "test read"() {
        given:
        BsonReader bsonReader = Mock(BsonReader) {
            1 * readDateTime() >> -914803200000
        }

        when:
        LocalDate converted = read(bsonReader)

        then:
        converted.year == 1941
        converted.month == Month.JANUARY
        converted.dayOfMonth == 5
    }

    void "test write"() {
        given:
        BsonWriter bsonWriter = Mock(BsonWriter)

        when:
        write(bsonWriter, localDate)

        then:
        1 * bsonWriter.writeDateTime(-914803200000)
    }
}