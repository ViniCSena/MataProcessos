package view;

import java.io.IOException;

import controller.KillController;

public class Main {
	
	static KillController killController = new KillController();

	public static void main(String[] args) {
		try {
			killController.killByName("/usr/bin/terminator");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
