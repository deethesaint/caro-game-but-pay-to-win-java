package Entry;

import Diaglog.MatchingDialog;
import Diaglog.RoomDialog;
import Socket.SocketHandler;
import View.CaroBoard;
import View.LobbyFrame;
import View.Login;
import View.ProfileFrame;
import View.SignUp;

public class Entry {
	public static Login login;
	public static SocketHandler socketHandler;
	public static MatchingDialog matchingDialog;
	public static RoomDialog roomDialog;
	public static SignUp signUp;
	public static LobbyFrame lobbyFrame;
	public static CaroBoard caroboard;
	public static ProfileFrame profile;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		socketHandler = new SocketHandler();
		socketHandler.connect();
		login = new Login();

		login.setVisible(true);
	}

	public static void onLoginSuccess(String data) {
		lobbyFrame = new LobbyFrame();
		login.dispose();
		lobbyFrame.setData(data);
		lobbyFrame.setVisible(true);
		lobbyFrame.musicAction(1);
		lobbyFrame.startMusic();
	}

	public static void onOutOfClientUI() {
		login = new Login();
		login.setVisible(true);
		socketHandler = new SocketHandler();
		socketHandler.connect();
		lobbyFrame.dispose();
	}
	
	public static void onSurrender() {
		lobbyFrame.setVisible(true);
	}

	public static void onDisconnectedToServer() {
		// code
	}
	
	public static void onRoomCreateClicked() {
		roomDialog = new RoomDialog();
		roomDialog.setLocationRelativeTo(lobbyFrame);
		roomDialog.setModal(true);
		roomDialog.setVisible(true);
	}

	public static void onMatchingClicked() {
		matchingDialog = new MatchingDialog();
		matchingDialog.setLocationRelativeTo(lobbyFrame);
		matchingDialog.setModal(true);
		matchingDialog.setVisible(true);
	}

	public static void onMatchAccepted(Integer playerMoveMark) {
		caroboard = new CaroBoard();
		caroboard.setVisible(true);
		caroboard.setMoveMark(playerMoveMark);
		lobbyFrame.setVisible(false);
	}

	public static void onMatchEnd() {
		caroboard.dispose();
		lobbyFrame.setVisible(true);
	}
	public static void onShowProfile(String data)
	{
		profile = new ProfileFrame();
		profile.setLocationRelativeTo(lobbyFrame);
		profile.setVisible(true);
		profile.setProfile(data);
	}
	
}
