package org.grails.plugins.bson.codecs

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.grails.plugins.bson.temporal.ConvertsLocalDate
import java.time.*

/**
 * A class to translate a {@link LocalDate} in MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateCodec implements Codec<LocalDate>, ConvertsLocalDate {

    @Override
    LocalDate decode(BsonReader reader, DecoderContext decoderContext) {
        return read(reader)
    }

    @Override
    void encode(BsonWriter writer, LocalDate value, EncoderContext encoderContext) {
        write(writer, value)
    }

    @Override
    Class<LocalDate> getEncoderClass() { LocalDate }
}
