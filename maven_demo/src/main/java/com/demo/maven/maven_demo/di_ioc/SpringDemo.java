package com.demo.maven.maven_demo.di_ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDemo {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// Java bean being managed by Spring IOC Container
		ApplicationContext context = new AnnotationConfigApplicationContext(Game.class, Score.class);

		// Uses Singleton design pattern
		// Only one instance of bean is created and its cached as well.
		// In the below code, instead of creating instance of Score class 5 times, it
		// uses the same instance(using caching) that was creating at the start
//		for (int i = 0; i < 5; i++) {
//			Score bean = context.getBean(Score.class);
////			Score bean = new Score();
//			bean.wins++;
//			System.out.println(bean.wins);
//
//		}

		Game game = context.getBean(Game.class);
		game.playGame();
		game.playGame();
		System.out.println(game.score.wins);

	}

}

class Score {

	int wins, losses, ties;

}

class Game {

	@Autowired
	Score score;

	public void playGame() {

		score.wins++;

	}
}