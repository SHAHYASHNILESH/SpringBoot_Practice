package design_patterns.behavioural.command.remoteControlSystem;

public class RemoteControl {

	private Command lightOnCommand;
	private Command lightOffCommand;
	private Command fanOnCommand;
	private Command fanOffCommand;

	public void setLightOnCommand(Command command) {
		this.lightOnCommand = command;
	}

	public void setLightOffCommand(Command command) {
		this.lightOffCommand = command;
	}

	public void setFanOnCommand(Command command) {
		this.fanOnCommand = command;
	}

	public void setFanOffCommand(Command command) {
		this.fanOffCommand = command;
	}

	public void pressLightOnButton() {
		if (lightOnCommand != null) {
			lightOnCommand.execute();
		}
	}

	public void pressLightOffButton() {
		if (lightOffCommand != null) {
			lightOffCommand.execute();
		}
	}

	public void pressFanOnButton() {
		if (fanOnCommand != null) {
			fanOnCommand.execute();
		}
	}

	public void pressFanOffButton() {
		if (fanOffCommand != null) {
			fanOffCommand.execute();
		}
	}
}
