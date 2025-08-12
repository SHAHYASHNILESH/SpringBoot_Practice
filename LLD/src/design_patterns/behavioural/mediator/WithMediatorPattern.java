package design_patterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
	void sendMessage(String msg, ChatUser user);

	void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {
	private List<ChatUser> users;

	public ChatRoom() {
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String msg, ChatUser sender) {
		for (ChatUser user : users) {
			if (user != sender) {
				user.recieveMessage(msg, sender);
			}
		}
	}

	@Override
	public void addUser(ChatUser user) {
		users.add(user);
	}
}

class ChatUser {
	private String name;
	private ChatMediator chatMediator;

	public ChatUser(String name, ChatMediator chatMediator) {
		this.name = name;
		this.chatMediator = chatMediator;
	}

	public void sendMessage(String msg) {
		System.out.println(this.name + "Sending a msg " + msg);
		chatMediator.sendMessage(msg, this);
	}

	public String getName() {
		return name;
	}

	public void recieveMessage(String msg, ChatUser sender) {
		System.out.println(this.name + " received message: '" + msg + "' from " + sender.getName());
	}
}

public class WithMediatorPattern {
	public static void main(String[] args) {
		ChatMediator chatRoom = new ChatRoom();
		ChatUser rahul = new ChatUser("Rahul", chatRoom);
		ChatUser amit = new ChatUser("Amit", chatRoom);
		ChatUser neha = new ChatUser("Neha", chatRoom);

		chatRoom.addUser(rahul);
		chatRoom.addUser(neha);
		chatRoom.addUser(amit);

		amit.sendMessage("Hi everyone");
	}
}