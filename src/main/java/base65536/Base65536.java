package base65536;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
public class Base65536
{
    private Base65536() {}
    /**
     * Returns a {@link Encoder} that encodes using the
     * <a href="#basic">Basic</a> type base65536 encoding scheme.
     *
     * @return  A Base65536 encoder.
     */
    public static Encoder getEncoder() {
        return Encoder.Base65536;
    }
    {
    /**
     * Returns a {@link Decoder} that decodes using the
     * <a href="#basic">Basic</a> type base65536 encoding scheme.
     *
     * @return  A Base65536 decoder.
     */
    public static Decoder getDecoder() {
         return Decoder.Base65536;
    }
    }
}