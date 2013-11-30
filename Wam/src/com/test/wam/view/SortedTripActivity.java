package com.test.wam.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.test.wam.Connection;
import com.test.wam.R;
import com.test.wam.service.ServiceCardReader;

public class SortedTripActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sorted_list);

		final ListView listView = (ListView) findViewById(R.id.listViewSortedBoard);

		InputStream is = null;

		try {
			is = getAssets().open("connections.json");
		} catch (IOException e) {

		}

		List<Connection> unsortedConnections;

		if (is != null)
			unsortedConnections = ServiceCardReader.getInstance().parseJsonConnections(
					is);
		else
			unsortedConnections = new ArrayList<Connection>();
		
		List<Connection> sortedConnection = ServiceCardReader.getInstance().sortConnections(unsortedConnections);

		listView.setAdapter(new MySortedAdapter(this, R.layout.item_list_sorted, sortedConnection));

	}
	
	
	/**
	 * 
	 * @param v
	 */
	public void sortTrip(View v){
		
	}

}

class MySortedAdapter extends ArrayAdapter<Connection> {

	private List<Connection> mCollection;
	private Context mContext;
	private int mResourceId;

	public MySortedAdapter(Context context, int resource, List<Connection> connections) {
		super(context, resource, connections);

		this.mContext = context;
		this.mCollection = connections;
		this.mResourceId = resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {

			// inflate the layout
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

			convertView = inflater.inflate(mResourceId, parent, false);

		}

		// object item based on the position
		Connection objectItem = mCollection.get(position);

		TextView textViewItem = (TextView) convertView
				.findViewById(R.id.textViewSortedItinerary);
		TextView textViewItem2 = (TextView) convertView
				.findViewById(R.id.textViewdescription);
		
		if(objectItem.getCard() == null){
			textViewItem.setText(objectItem.getFrom());
			textViewItem2.setText("");
		}else{
			textViewItem.setText(objectItem.toString());
			
			textViewItem2.setText(objectItem.getDescription());
		}

		

		return convertView;

	}

}
