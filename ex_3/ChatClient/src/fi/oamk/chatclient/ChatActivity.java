package fi.oamk.chatclient;



import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class ChatActivity extends Activity {
	// set your name here into NICKNAME variable
	static final String NICKNAME = "Donald Student";
	// set PC's IP address into SERVER_IP_ADDRESS varable
	static final String SERVER_IP_ADDRESS = "xxx.xxx.x.xxx";

	// define empty InetAddress, serverAddress, and Socket socket

	// define TextView ja EditText -muuttujat

	// define a variable for the instance of CommunicationThread class

	// ---used for updating the UI on the main activity---
	static Handler UIupdater = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int numOfBytesReceived = msg.arg1;
			byte[] buffer = (byte[]) msg.obj;

			// ---convert the entire byte array to string---
			String strReceived = new String(buffer);

			// ---extract only the actual string received---
			strReceived = strReceived.substring(0, numOfBytesReceived);

			// update TextView. Below the example, the name of a variable is txtMessagesReceived
//			txtMessagesReceived.setText(txtMessagesReceived.getText()
//					.toString() + strReceived);
		}
	};

	private class CreateCommThreadTask extends AsyncTask<Void, Integer, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			// remove the comments of the try-catch block
			
//			try {
//				Log.i("ChatClient", "doInBackground");
//				//set the serverAddress object using the method getByName of InetAddress class and IP address (string)
//
//				//create Socket object into a socket varable and set as the parameter the serverAddress object and the needed port nro
//				
//				//create CommunicationThread object into the communicationThread varable and set the socket as a parameter
//				//run communicationThread
//				
//				//send the nickname to a server using sendToServer method
//				
//			} catch (UnknownHostException e) {
//				Log.w("ChatClient", e.getLocalizedMessage());
//			} catch (IOException e) {
//				Log.w("ChatClient", e.getLocalizedMessage());
//			}
			return null;
		}
	}

	private class WriteToServerTask extends AsyncTask<byte[], Void, Void> {
		protected Void doInBackground(byte[]... data) {
			// call the write method of the communicationThread a data array (index = 0) as a parameter
			return null;
		}
	}

	private class CloseSocketTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			// remove comments from the try-catch block
//			
//			try {
//				// call the cancel methos of communicationThread 
//			} 
//			catch (IOException e) {
//				Log.w("ChatClient", e.getLocalizedMessage());
//			}
			return null;
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("ChatClient", "ChatActivity.onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		// get TextView and EditText from the layot using the findViewById function
	}

	public void onClickSend(View view) {
		Log.i("ChatClient", "ChatActivity.onClickSend");
		// call sendToServer method using an EditText data string as parameter
	}

	private void sendToServer(String message) {
		byte[] theByteArray = message.getBytes();
		new WriteToServerTask().execute(theByteArray);
	}

	@Override
	public void onResume() {
		super.onResume();
		new CreateCommThreadTask().execute();
	}

	@Override
	public void onPause() {
		super.onPause();
		new CloseSocketTask().execute();
	}

}
