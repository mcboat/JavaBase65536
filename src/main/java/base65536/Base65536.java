package base65536;

import java.util.Objects;

public class Base65536 {
	/**
	* Returns a {@link Encoder} that encodes using the
	* <a href="#basic">Basic</a> type base65536 encoding scheme.
	*
	* @return  A Base65536 encoder.
	*/
	public static Encoder getEncoder() {
		return Encoder.BASE65536;
	}

	/**
	 * Returns a {@link Encoder} that encodes using the
	 * <a href="#url">URL and Filename safe</a> type base65536
	 * encoding scheme.
	 *
	 * @return  A Base65536 encoder.
	 */
	public static Encoder getUrlEncoder() {
		return Encoder.BASE65536_URLSAFE;
	}

	/**
	 * Returns a {@link Encoder} that encodes using the
	 * <a href="#mime">MIME</a> type base65536 encoding scheme.
	 *
	 * @return  A Base65536 encoder.
	 */
	public static Encoder getMimeEncoder() {
		return Encoder.BASE65536_MIME;
	}

	/**
	 * Returns a {@link Encoder} that encodes using the
	 * <a href="#mime">MIME</a> type base65536 encoding scheme
	 * with specified line length and line separators.
	 *
	 * @param   lineLength
	 *          the length of each output line (rounded down to nearest multiple
	 *          of 4). If {@code lineLength <= 0} the output will not be separated
	 *          in lines
	 * @param   lineSeparator
	 *          the line separator for each output line
	 *
	 * @return  A Base65536 encoder.
	 *
	 * @throws  IllegalArgumentException if {@code lineSeparator} includes any
	 *          character of "The Base65536 Alphabet" as specified in Table 1 of
	 *          RFC 2045.
	 */
	public static Encoder getMimeEncoder(int lineLength, byte[] lineSeparator) {
		Objects.requireNonNull(lineSeparator);
		int[] base65536 = Decoder.fromBase65536;
		for (byte b : lineSeparator) {
			if (base65536[b & 0xff] != -1)
				throw new IllegalArgumentException(
						"Illegal base65536 line separator character 0x" + Integer.toString(b, 16));
		}
		if (lineLength <= 0) {
			return Encoder.BASE65536;
		}
		return new Encoder(false, lineSeparator, lineLength >> 2 << 2, true);
	}

	/**
	 * Returns a {@link Decoder} that decodes using the
	 * <a href="#basic">Basic</a> type base65536 encoding scheme.
	 *
	 * @return  A Base65536 decoder.
	 */
	public static Decoder getDecoder() {
		return Decoder.BASE65536;
	}

	/**
	 * Returns a {@link Decoder} that decodes using the
	 * <a href="#url">URL and Filename safe</a> type base65536
	 * encoding scheme.
	 *
	 * @return  A Base65536 decoder.
	 */
	public static Decoder getUrlDecoder() {
		return Decoder.BASE65536_URLSAFE;
	}

	/**
	 * Returns a {@link Decoder} that decodes using the
	 * <a href="#mime">MIME</a> type base65536 decoding scheme.
	 *
	 * @return  A Base65536 decoder.
	 */
	public static Decoder getMimeDecoder() {
		return Decoder.BASE65536_MIME;
	}

	public static class Encoder {
		// TODO: put some actual stuff in the encoder
		public static Encoder BASE65536 = new Encoder();
		public static Encoder BASE65536_URLSAFE = new Encoder();
		public static Encoder BASE65536_MIME = new Encoder();

		Encoder() {}
		
		private Encoder(boolean isURL, byte[] newline, int linemax, boolean doPadding) {}
	}

	public static class Decoder {
		public static int[] fromBase65536;
		// TODO: put some actual stuff in the decoder
		public static Decoder BASE65536 = new Decoder();
		public static Decoder BASE65536_URLSAFE = new Decoder();
		public static Decoder BASE65536_MIME = new Decoder();

		Decoder() {}
	}
}
