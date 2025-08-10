package design_patterns.behavioural.command.remoteControlSystem;

public class Exercise {

	// Do not modify the run method; it is designed to manage command execution and
	// control the devices.
	public void run() {

		// Create devices
		Light light = new Light();
		Fan fan = new Fan();

		// Create commands
		Command lightOn = new LightCommands.LightOnCommand(light);
		Command lightOff = new LightCommands.LightOffCommand(light);
		Command fanOn = new FanCommands.FanOnCommand(fan);
		Command fanOff = new FanCommands.FanOffCommand(fan);

		// Create remote control
		// TODO: Instantiate the RemoteControl object to manage commands.
		RemoteControl remoteControl = new RemoteControl();

		// TODO: Set the command for turning the light on using the LightOnCommand using
		// remoteControl object.
		remoteControl.setLightOnCommand(lightOn);

		// TODO: Set the command for turning off the light using LightOffCommand using
		// remoteControl object.
		remoteControl.setLightOffCommand(lightOff);

		// TODO: Set the command for turning on the fan using FanOnCommand using
		// remoteControl object.
		remoteControl.setFanOnCommand(fanOn);

		// TODO: Set the command for turning off the fan using FanOffCommand using
		// remoteControl object.
		remoteControl.setFanOffCommand(fanOff);

		// Test the functionality
		// TODO: Press the button to turn on the light and verify the output.
		remoteControl.pressLightOnButton();

		// TODO: Press the button to turn off the light and verify the output.
		remoteControl.pressLightOffButton();

		// TODO: Press the button to turn on the fan and verify the output.
		remoteControl.pressFanOnButton();

		// TODO: Press the button to turn off the fan and verify the output.
		remoteControl.pressFanOffButton();
	}
}
