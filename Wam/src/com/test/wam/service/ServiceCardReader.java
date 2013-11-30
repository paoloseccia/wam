package com.test.wam.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;

import com.test.wam.BoardingCard;
import com.test.wam.Connection;
import com.test.wam.Transportation;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ServiceCardReader {

	private static ServiceCardReader mInstance;

	private ServiceCardReader() {
	}

	/**
	 * Singleton
	 * 
	 * @return uinique instance of class
	 */
	public static synchronized ServiceCardReader getInstance() {
		if (mInstance == null)
			mInstance = new ServiceCardReader();

		return mInstance;
	}

	public List<Connection> parseJsonConnections(InputStream jsonStream) {
		try {
			return readJsonStream(jsonStream);
		} catch (IOException e) {
			return null;
		}
	}

	private List<Connection> readJsonStream(InputStream in) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try {
			return readConnectionsArray(reader);
		} finally {
			reader.close();
		}
	}

	private List<Connection> readConnectionsArray(JsonReader reader)
			throws IOException {
		List<Connection> messages = new ArrayList<Connection>();

		reader.beginArray();
		while (reader.hasNext()) {
			messages.add(readConnection(reader));
		}
		reader.endArray();
		return messages;
	}

	private Connection readConnection(JsonReader reader) throws IOException {

		String type = null;
		String from = null;
		String to = null;
		String seat = null;
		String number = null;
		String place = null;
		String info = null;

		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("type")) {
				type = reader.nextString();
			} else if (name.equals("from")) {
				from = reader.nextString();
			} else if (name.equals("to")) {
				to = reader.nextString();
			} else if (name.equals("seat") && reader.peek() != JsonToken.NULL) {
				seat = reader.nextString();
			} else if (name.equals("number") && reader.peek() != JsonToken.NULL) {
				number = reader.nextString();
			} else if (name.equals("placeToTake")
					&& reader.peek() != JsonToken.NULL) {
				place = reader.nextString();
			} else if (name.equals("info") && reader.peek() != JsonToken.NULL) {
				info = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();

		return new Connection(from, to, new BoardingCard(seat,
				new Transportation(type, number, place, info)));
	}

	/**
	 * Sort Connection List
	 * 
	 * @param unsortedConnections
	 * @retrn
	 */
	public List<Connection> sortConnections(
			final List<Connection> unsortedConnections) {

		Connection[] arrayConnections = new Connection[unsortedConnections
				.size()];

		for (int i = 0; i < arrayConnections.length; i++) {
			arrayConnections[i] = unsortedConnections.get(i);
		}

		for (int i = 0; i < arrayConnections.length; i++) {

			for (int j = i + 1; j < arrayConnections.length; j++) {

				if (arrayConnections[i].getFrom().equalsIgnoreCase(
						arrayConnections[j].getTo())) {
					Connection c = arrayConnections[j];
					arrayConnections[j] = arrayConnections[i];
					arrayConnections[i] = c;
				}

			}
		}

		List<Connection> sortedConnections = new ArrayList<Connection>();
		for (int j = 0; j < arrayConnections.length; j++) {
			sortedConnections.add(arrayConnections[j]);
		}
		
		sortedConnections.add(new Connection("You have arrived at your final destination.", "", null));

		return sortedConnections;
	}

}
