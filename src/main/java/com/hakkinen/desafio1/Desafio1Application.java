package com.hakkinen.desafio1;

import com.hakkinen.desafio1.entities.Order;
import com.hakkinen.desafio1.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	private OrderService orderService;

	public Desafio1Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        /*System.out.println("=========== EXEMPLO 1 ==============");
		Order exemplo1 = new Order(1034, 150.00, 20.0);
		double total1 = orderService.total(exemplo1);
		System.out.println("Pedido código " + exemplo1.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total1);

		System.out.println("=========== EXEMPLO 2 ==============");
		Order exemplo2 = new Order(2282, 800.00, 10.0);
		double total2 = orderService.total(exemplo2);
		System.out.println("Pedido código " + exemplo2.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total2);

		System.out.println("=========== EXEMPLO 3 ==============");
		Order exemplo3 = new Order(1309, 95.90, 0.0);
		double total3 = orderService.total(exemplo3);
		System.out.println("Pedido código " + exemplo3.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total3);*/
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}
}
